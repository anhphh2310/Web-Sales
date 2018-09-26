package phhanh.tma.service;

import java.util.List;
import java.util.UUID;

import phhanh.tma.model.Product;
import phhanh.tma.model.cassandra.CassProduct;

public interface ProductService {

	List<Product> listProduct();
	
	List<CassProduct> listCassProduct();
	
	Product getProduct(UUID id);
	
	CassProduct getCassProduct(UUID id);
	
	void save(Product product);
	
	void delete(UUID id);
	
}
