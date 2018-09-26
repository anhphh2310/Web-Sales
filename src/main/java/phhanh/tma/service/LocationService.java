package phhanh.tma.service;

import java.util.List;
import java.util.UUID;

import phhanh.tma.model.Location;
import phhanh.tma.model.cassandra.CassLocation;

public interface LocationService {

	List<Location> listLocation();
	
	List<CassLocation> listCassLocation();
	
	Location get(UUID id);
	
	CassLocation getCassLocation(UUID id);
	
	void save(Location location);
	
	void delete(UUID id);
}
