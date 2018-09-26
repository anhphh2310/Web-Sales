package phhanh.tma.service;

import java.util.List;
import java.util.UUID;

import phhanh.tma.model.Time;
import phhanh.tma.model.cassandra.CassTime;

public interface TimeService {

	List<Time> listTime();
	
	List<CassTime> listCassTime();
	
	Time getTime(UUID id);
	
	CassTime getCassTime(UUID id);
	
	void save(Time time);
	
	void delete(UUID id);
	
}
