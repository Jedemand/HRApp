package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleMakeService {
    Iterable<VehicleMake> listAllVehicleMakes();
    VehicleMake getVehicleMakeById(Integer id);
    VehicleMake saveVehicleMake(VehicleMake vehicleMake);
    Iterable<VehicleMake> saveVehicleMakeList(Iterable<VehicleMake> vehicleMakeList);
    void deleteMake(Integer id);

    @Query("select e.modelList from VehicleMake e where e.vehicleMakeName = ?1")
    List<VehicleModel> findModelList(String vehicleMakeName);
}


