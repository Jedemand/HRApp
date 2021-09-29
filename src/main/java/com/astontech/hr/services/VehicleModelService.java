package com.astontech.hr.services;


import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleModelService {
    Iterable<VehicleModel> listAllVehicleModels();
    VehicleModel getVehicleModelById(Integer id);
    VehicleModel saveVehicleModel(VehicleModel vehicleModel);
    Iterable<VehicleModel> saveVehicleModelList(Iterable<VehicleModel> vehicleModelList);
    void deleteModel(Integer id);

    @Query("select e.vehicleList from VehicleModel e where e.vehicleModelName = ?1")
    List<Vehicle> findVehicleList(String vehicleModelName);

    @Query("select e.vehicleList from VehicleModel e")
    List<Vehicle> findAllVehicleList();

}
