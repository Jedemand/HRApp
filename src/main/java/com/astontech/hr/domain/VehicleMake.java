package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class VehicleMake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vehicleMake_id")
    private Integer Id;

    @Version
    private Integer version;

    private String vehicleMakeName;
    //private Date CreateDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VehicleModel> modelList;

    //region Contructors

    public VehicleMake() {
    }

    public VehicleMake(String vehicleMakeName) {
        this.vehicleMakeName = vehicleMakeName;
    }

    public VehicleMake(String vehicleMakeName, List<VehicleModel> modelList) {
        this.vehicleMakeName = vehicleMakeName;
        this.modelList = modelList;
    }


    //end region


    //region GetSet

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getVehicleMakeName() {
        return vehicleMakeName;
    }

    public void setVehicleMakeName(String vehicleMakeName) {
        this.vehicleMakeName = vehicleMakeName;
    }

//    public Date getCreateDate() {
//        return CreateDate;
//    }
//
//    public void setCreateDate(Date createDate) {
//        CreateDate = createDate;
//    }

    public List<VehicleModel> getModelList() {
        return modelList;
    }

    public void setModelList(List<VehicleModel> modelList) {
        this.modelList = modelList;
    }

//endregion

    @Override
    public String toString() {
        return "VehicleMake{" +
                "Id=" + Id +
                ", version=" + version +
                ", vehicleMakeName='" + vehicleMakeName + '\'' +
                ", modelList=" + modelList +
                '}';
    }
}
