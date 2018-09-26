package phhanh.tma.repository.cassandra;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import phhanh.tma.model.cassandra.CassTime;

public interface CassTimeRepository extends CrudRepository<CassTime, UUID>{

}
