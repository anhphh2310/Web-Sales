package phhanh.tma.repository.cassandra;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import phhanh.tma.model.cassandra.CassProduct;

public interface CassProductRepository extends CrudRepository<CassProduct, UUID>{

}
