package com.astontech.hr.services;

import com.astontech.hr.domain.Vehicle;
import org.springframework.stereotype.Service;

@Service
public interface VehicleService {
    Iterable<Vehicle> listAllVehicles();
    Vehicle getVehicleById(Integer id);
    Vehicle saveVehicle(Vehicle vehicle);
    Iterable<Vehicle> saveVehicleList(Iterable<Vehicle> vehicleList);
    void delete(Integer id);

  
}
