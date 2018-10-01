package tma.datraining.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import tma.datraining.model.Product;

public interface ProductRepository extends CrudRepository<Product, UUID>{

}
