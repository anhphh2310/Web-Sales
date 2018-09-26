package phhanh.tma.service;

import java.util.List;

import phhanh.tma.model.Sales;
import phhanh.tma.model.cassandra.CassSales;

public interface SaleService {

	List<Sales> listSales();
	
	List<CassSales> listCassSales();
	
	
}
