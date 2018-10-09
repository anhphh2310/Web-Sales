package tma.datraining.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tma.datraining.converter.DateTimeToTimestampConverter;
import tma.datraining.dto.TimeDTO;
import tma.datraining.exception.NotFoundDataException;
import tma.datraining.model.Sales;
import tma.datraining.model.Time;
import tma.datraining.model.cassandra.CassTime;
import tma.datraining.service.SalesService;
import tma.datraining.service.TimeService;
import tma.datraining.service.cassandra.CassTimeService;

@RestController
@RequestMapping("/time")
public class TimeController {

	@Autowired
	private TimeService timeSer;

	@Autowired
	private SalesService salesSer;

	@Autowired
	private CassTimeService cassSer;
	
	@Autowired
	private DateTimeToTimestampConverter converter;
	
	
	@GetMapping(value="/convert",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<TimeDTO> getConvertTime(){
		List<TimeDTO> list = new ArrayList<>();
		cassSer.list().forEach(e -> list.add(convertCassToDTO(e)));
		list.forEach(e -> timeSer.save(converTime(e)));
		return list;
	}
	
	@GetMapping(value = { "/list" }, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<TimeDTO> getTimes() {
		List<TimeDTO> list = new ArrayList<>();
		timeSer.list().forEach(e->list.add(convertDTO(e)));
		return list;
	}

	@GetMapping(value = { "/{timeId}" }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public TimeDTO getTime(@PathVariable("timeId") String timeId) {
		TimeDTO time = null;
		try {
			time = convertDTO(timeSer.get(UUID.fromString(timeId)));
		} catch (IllegalArgumentException e) {
			throw new NotFoundDataException("");
		}

		return time;
	}

	@PostMapping(value = { "/time" },produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public TimeDTO saveTime(@RequestBody TimeDTO tim) {
		Time time = converTime(tim);
		timeSer.save(time);
		return tim;
	}

	@PutMapping(value = { "/time/{timeId}" }, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public TimeDTO updateTime(@RequestBody TimeDTO tim,@PathVariable("timeId")String timeId) {
		UUID id = null;
		try {
			id = UUID.fromString(timeId);
		}
		catch (IllegalArgumentException e) {
			throw new NotFoundDataException("Time id");
		}
		if(timeSer.get(id)==null) {
			throw new NotFoundDataException("Time id");
		}
		Time time = converTime(tim);
		Set<Sales> sales = new HashSet<>();
		sales.addAll(salesSer.findByTime(time));
		time.setSales(sales);
		timeSer.update(time.getTimeId(), time);
		TimeDTO timeDTO = convertDTO(timeSer.get(time.getTimeId()));
		return timeDTO;
	}

	@DeleteMapping(value = { "/time/{timeId}" },  produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void deleteTime(@PathVariable("timeId") String timeId) {
		TimeDTO time = null;
		try {
			time = convertDTO(timeSer.get(UUID.fromString(timeId)));
		} catch (IllegalArgumentException e) {
			throw new NotFoundDataException("");
		}
		timeSer.delete(time.getTimeId());
		System.out.println("Delete time : " + timeId);
	}

	//Convert
	//Time to DTO
	public TimeDTO convertDTO(Time e) {
		TimeDTO time = new TimeDTO();
		if (e == null) {
			throw new NotFoundDataException("");
		}
		time.setTimeId(e.getTimeId());
		time.setMonth(e.getMonth());
		time.setQuarter(e.getQuarter());
		time.setYear(e.getYear());
		time.setCreateAt((e.getCreateAt()));
		time.setModifiedAt(e.getModifiedAt());
		return time;
	}

	//DTO to time
	public Time converTime(TimeDTO time) {
		Time tim = null;
		tim = new Time(time.getMonth(), time.getQuarter(), time.getYear(), time.getCreateAt(), time.getModifiedAt());
		tim.setTimeId(time.getTimeId());
		return tim;
	}
	
	//Cass to DTO
	private TimeDTO convertCassToDTO(CassTime e) {
		if(e== null) {
			throw new NotFoundDataException("");
		}
		TimeDTO time = new TimeDTO();
		time.setTimeId(e.getTimeId());
		time.setMonth(e.getMonth());
		time.setQuarter(e.getQuarter());
		time.setYear(e.getYear());
		time.setCreateAt(converter.convert(e.getCreateAt()));
		time.setModifiedAt(converter.convert(e.getModifiedAt()));
		return time;
	}
}
