package tma.datraining.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tma.datraining.model.Product;
import tma.datraining.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImp implements ProductService{

	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public List<Product> list() {
		List<Product> list = new ArrayList<>();
		productRepo.findAll().forEach(e ->list.add(e));
		return list;
	}

	@Override
	public UUID save(Product product) {
		productRepo.save(product);
		return product.getProductId();
	}

	@Override
	public Product get(UUID id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).get();
	}

	@Override
	public void update(UUID id, Product product) {
		// TODO Auto-generated method stub
		productRepo.save(product);
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		productRepo.delete(productRepo.findById(id).get());
	}

}
