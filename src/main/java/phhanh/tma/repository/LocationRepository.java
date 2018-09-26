package phhanh.tma.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import phhanh.tma.model.Location;

public interface LocationRepository extends CrudRepository<Location, UUID> {

}
