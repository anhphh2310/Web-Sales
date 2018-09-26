package phhanh.tma.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import phhanh.tma.model.Product;

public interface ProductRepository extends CrudRepository<Product, UUID>{

}
