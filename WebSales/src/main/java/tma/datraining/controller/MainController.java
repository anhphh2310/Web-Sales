package tma.datraining.controller;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tma.datraining.model.Product;
import tma.datraining.model.cassandra.CassLocation;
import tma.datraining.model.cassandra.CassProduct;
import tma.datraining.model.cassandra.CassSales;
import tma.datraining.model.cassandra.CassTime;
import tma.datraining.service.cassandra.CassLocationService;
import tma.datraining.service.cassandra.CassProductService;
import tma.datraining.service.cassandra.CassSalesService;
import tma.datraining.service.cassandra.CassTimeService;

@RestController
public class MainController {

	@Autowired
	private CassLocationService cassLocaSer;

	@Autowired
	private CassProductService cassProductSer;

	@Autowired
	private CassSalesService cassSalesSer;

	@Autowired
	private CassTimeService cassTimeSer;

	private boolean flag = false;

	@RequestMapping("/")
	@ResponseBody
	public String getMainPage() {
		if (flag == false) {
			autoCreate();
			flag = true;
		}
		return "Welcome to WebSales";
	}

	public void autoCreate() {
		// Location
		java.sql.Timestamp time1 = java.sql.Timestamp.valueOf("2018-08-27 10:10:10.0");
		java.sql.Timestamp time2 = java.sql.Timestamp.valueOf("2018-08-28 10:10:10.0");

		UUID idL1 = cassLocaSer.save(new CassLocation(UUID.randomUUID(), "VIETNAM", "Ho Chi Minh City", time1, time2));
		UUID idL2 = cassLocaSer.save(new CassLocation(UUID.randomUUID(), "VIETNAM", "Ha Noi City", time1, time2));
		UUID idL3 = cassLocaSer.save(new CassLocation(UUID.randomUUID(), "CHINA", "Beijing", time1, time2));
		UUID idL4 = cassLocaSer.save(new CassLocation(UUID.randomUUID(), "KOREA", "Seoul City", time1, time2));
		UUID idL5 = cassLocaSer.save(new CassLocation(UUID.randomUUID(), "JAPAN", "Tokyo City", time1, time2));
		UUID idL6 = cassLocaSer.save(new CassLocation(UUID.randomUUID(), "RUSSIA", "Moscow City", time1, time2));
		UUID idL7 = cassLocaSer.save(new CassLocation(UUID.randomUUID(), "ENGLAND", "London City", time1, time2));
		UUID idL8 = cassLocaSer.save(new CassLocation(UUID.randomUUID(), "AMERICAN", "Ho Chi Minh City", time1, time2));
		UUID idL9 = cassLocaSer.save(new CassLocation(UUID.randomUUID(), "CANADA", "Ottawa City", time1, time2));
		UUID idL10 = cassLocaSer.save(new CassLocation(UUID.randomUUID(), "AUSTRALIA", "Canbera City", time1, time2));
		UUID idL11 = cassLocaSer.save(new CassLocation(UUID.randomUUID(), "SPAIN", "Madrid City", time1, time2));

		// Product
		java.sql.Timestamp time3 = java.sql.Timestamp.valueOf("2018-09-27 13:10:10.0");
		java.sql.Timestamp time4 = java.sql.Timestamp.valueOf("2018-09-28 16:10:10.0");

		UUID idP1 = cassProductSer.save(new CassProduct(UUID.randomUUID(), 100, "CREEN", "Inv-1", time3, time4));
		UUID idP2 = cassProductSer.save(new CassProduct(UUID.randomUUID(), 100, "SCREEN", "Inv-1", time3, time4));
		UUID idP3 = cassProductSer.save(new CassProduct(UUID.randomUUID(), 105, "CABLE", "Inv-2", time3, time4));
		UUID idP4 = cassProductSer.save(new CassProduct(UUID.randomUUID(), 170, "MOUSE", "Inv-3", time3, time4));
		UUID idP5 = cassProductSer.save(new CassProduct(UUID.randomUUID(), 190, "KEYBOARD", "Inv-4", time3, time4));
		UUID idP6 = cassProductSer.save(new CassProduct(UUID.randomUUID(), 250, "SPEAKER", "Inv-5", time3, time4));
		UUID idP7 = cassProductSer.save(new CassProduct(UUID.randomUUID(), 199, "RECORDER", "Inv-6", time3, time4));
		UUID idP8 = cassProductSer.save(new CassProduct(UUID.randomUUID(), 180, "CORE", "Inv-7", time3, time4));
		UUID idP9 = cassProductSer.save(new CassProduct(UUID.randomUUID(), 201, "PRINTER", "Inv-8", time3, time4));
		UUID idP10 = cassProductSer.save(new CassProduct(UUID.randomUUID(), 120, "SCANNER", "Inv-9", time3, time4));
		UUID idP11 = cassProductSer.save(new CassProduct(UUID.randomUUID(), 231, "STORAGE", "Inv-10", time3, time4));

		// Time
		java.sql.Timestamp time5 = java.sql.Timestamp.valueOf("2018-09-27 1:10:10.0");
		java.sql.Timestamp time6 = java.sql.Timestamp.valueOf("2018-09-28 5:10:10.0");

		UUID idT1 = cassTimeSer.save(new CassTime(UUID.randomUUID(), 9, 27, 2018, time5, time6));
		UUID idT2 = cassTimeSer.save(new CassTime(UUID.randomUUID(), 9, 26, 2018, time5, time6));
		UUID idT3 = cassTimeSer.save(new CassTime(UUID.randomUUID(), 9, 25, 2018, time5, time6));
		UUID idT4 = cassTimeSer.save(new CassTime(UUID.randomUUID(), 9, 24, 2018, time5, time6));

		// Sale
		java.sql.Timestamp time7 = java.sql.Timestamp.valueOf("2018-09-27 3:10:10.0");
		java.sql.Timestamp time8 = java.sql.Timestamp.valueOf("2018-09-28 5:10:10.0");

		cassSalesSer.save(new CassSales(idP1, idT1, idL1, new BigDecimal("100.0"), time7, time8));
		cassSalesSer.save(new CassSales(idP2, idT2, idL5, new BigDecimal("100.0"), time7, time8));
		cassSalesSer.save(new CassSales(idP3, idT4, idL4, new BigDecimal("150.0"), time7, time8));
		cassSalesSer.save(new CassSales(idP4, idT1, idL6, new BigDecimal("90.78"), time7, time8));
		cassSalesSer.save(new CassSales(idP5, idT3, idL2, new BigDecimal("190.0"), time7, time8));
		cassSalesSer.save(new CassSales(idP7, idT2, idL3, new BigDecimal("462.0"), time7, time8));
		cassSalesSer.save(new CassSales(idP8, idT2, idL7, new BigDecimal("462.0"), time7, time8));
		cassSalesSer.save(new CassSales(idP9, idT4, idL9, new BigDecimal("462.0"), time7, time8));
		cassSalesSer.save(new CassSales(idP10, idT4, idL10, new BigDecimal("462.0"), time7, time8));
		cassSalesSer.save(new CassSales(idP11, idT1, idL11, new BigDecimal("462.0"), time7, time8));
		cassSalesSer.save(new CassSales(idP6, idT3, idL8, new BigDecimal("462.0"), time7, time8));

	}

	public CassProduct convertCassProduct(Product product) {
		CassProduct cassPro = null;
		cassPro = new CassProduct(product.getProductId(), product.getItem(), product.getClassProduct(),
				product.getInventory(), product.getCreateAt(), product.getModifiedAt());
		return cassPro;
	}
}
