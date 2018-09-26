package phhanh.tma.repository;

import org.springframework.data.repository.CrudRepository;

import phhanh.tma.model.Sales;
import phhanh.tma.model.SalesId;

public interface SalesRepository extends CrudRepository<Sales, SalesId> {

}
