package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.repositories.VehicleModelRepository;
import com.astontech.hr.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleModelServiceImpl implements VehicleModelService {
    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    @Override
    public Iterable<VehicleModel> listAllVehicleModels() {
        return vehicleModelRepository.findAll();
    }

    @Override
    public VehicleModel getVehicleModelById(Integer id) {
        return vehicleModelRepository.findOne(id);
    }

    @Override
    public VehicleModel saveVehicleModel(VehicleModel vehicleModel) {
        return vehicleModelRepository.save(vehicleModel);
    }

    @Override
    public Iterable<VehicleModel> saveVehicleModelList(Iterable<VehicleModel> vehicleModelList) {
        System.out.println("Vehicle List Changed");
        return vehicleModelRepository.save(vehicleModelList);

    }

    @Override
    public void deleteModel(Integer id) {
       vehicleModelRepository.delete(id);
    }

    @Override
    public List<Vehicle> findVehicleList(String vehicleModelName) {
        return vehicleModelRepository.findVehicleList(vehicleModelName);
    }

    @Override
    public List<Vehicle> findAllVehicleList() {
        return vehicleModelRepository.findAllVehicleList();
    }
}
