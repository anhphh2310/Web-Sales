package tma.datraining.service.cassandra;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tma.datraining.model.cassandra.CassProduct;
import tma.datraining.repository.cassandra.CassProductRepo;

@Service
@Transactional
public class CassProductServiceImp implements CassProductService {

	@Autowired
	private CassProductRepo cassRepo;
	
	@Override
	public List<CassProduct> list() {
		List<CassProduct> list = new ArrayList<>();
		cassRepo.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public CassProduct get(UUID id) {
		CassProduct product = null;
		product = cassRepo.findById(id).get();
		return product;
	}

	@Override
	public UUID save(CassProduct product) {
		cassRepo.save(product);
		return product.getProductId();
	}

	@Override
	public void update(UUID id, CassProduct product) {
		cassRepo.save(product);

	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		cassRepo.delete(cassRepo.findById(id).get());
	}

}
