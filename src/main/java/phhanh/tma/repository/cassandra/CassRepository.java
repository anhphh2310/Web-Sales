package phhanh.tma.repository.cassandra;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import phhanh.tma.model.cassandra.CassSales;

public interface CassRepository extends CrudRepository<CassSales, UUID>{

}
