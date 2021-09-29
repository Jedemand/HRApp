package com.astontech.hr.repositories;


import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleModelRepository extends CrudRepository<VehicleModel, Integer> {

    @Query("select e.vehicleList from VehicleModel e where e.vehicleModelName = ?1")
    List<Vehicle> findVehicleList(String vehicleModelName);

    @Query("select e.vehicleList from VehicleModel e")
    List<Vehicle> findAllVehicleList();
}
