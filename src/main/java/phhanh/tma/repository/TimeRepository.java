package phhanh.tma.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import phhanh.tma.model.Time;

public interface TimeRepository extends CrudRepository<Time, UUID>{

}
