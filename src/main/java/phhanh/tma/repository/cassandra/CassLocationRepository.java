package phhanh.tma.repository.cassandra;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import phhanh.tma.model.cassandra.CassLocation;

public interface CassLocationRepository extends CrudRepository<CassLocation, UUID> {

}
