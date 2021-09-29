package com.astontech.hr.repositories;


import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleMakeRepository extends CrudRepository<VehicleMake, Integer> {

    @Query("select e.modelList from VehicleMake e where e.vehicleMakeName = ?1")
    List<VehicleModel> findModelList(String vehicleMakeName);
}
