package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class VehicleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vehicleModel_id")
    private Integer Id;


    @Version
    private Integer version;

    private String vehicleModelName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vehicle> vehicleList;

    //region Constructors


    public VehicleModel() {}

    public VehicleModel(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }

    public VehicleModel(String vehicleModelName, List<Vehicle> vehicleList) {
        this.vehicleModelName = vehicleModelName;
        this.vehicleList = vehicleList;
    }

//endregion


    //region GetSet

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getVehicleModelName() {
        return vehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
        System.out.println("Vehicle List Changed");
    }

    //endregion

    @Override
    public String toString() {
        return "VehicleModel{" +
                "Id=" + Id +
                ", version=" + version +
                ", vehicleModelName='" + vehicleModelName + '\'' +
                ", vehicleList=" + vehicleList +
                '}';
    }
}
