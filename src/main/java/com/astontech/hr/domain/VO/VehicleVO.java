package com.astontech.hr.domain.VO;

import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleModel;

import java.util.Date;
import java.util.List;

public class VehicleVO {

    //vehicle params
    private String newYear;
    private String newLicensePlate;
    private String newVIN;
    private String newColor;
    private boolean newIsPurchased;
    private String newPurchasePrice;


    //model params
    private String newVehicleModelName;
    private List<Vehicle> newVehicleArray;

    //make params
    private String newVehicleMakeName;

    private List<VehicleModel> newModelArray;

    //region Constructors
    public VehicleVO() {}


    //endregion

    //region Methods
    public Vehicle hydrateVehicle() {
      Vehicle hydratedVehicle = new Vehicle(Integer.parseInt(this.newYear), this.newLicensePlate, this.newVIN, this.newColor, this.newIsPurchased, Integer.parseInt(this.newPurchasePrice));
      return hydratedVehicle;
     }



    //endregion

    //region


    public String getNewYear() {
        return newYear;
    }

    public void setNewYear(String newYear) {
        this.newYear = newYear;
    }

    public String getNewLicensePlate() {
        return newLicensePlate;
    }

    public void setNewLicensePlate(String newLicensePlate) {
        this.newLicensePlate = newLicensePlate;
    }

    public String getNewVIN() {
        return newVIN;
    }

    public void setNewVIN(String newVIN) {
        this.newVIN = newVIN;
    }

    public String getNewColor() {
        return newColor;
    }

    public void setNewColor(String newColor) {
        this.newColor = newColor;
    }

    public boolean isNewIsPurchased() {
        return newIsPurchased;
    }

    public void setNewIsPurchased(boolean newIsPurchased) {
        this.newIsPurchased = newIsPurchased;
    }


    public String getNewPurchasePrice() {
        return newPurchasePrice;
    }

    public void setNewPurchasePrice(String newPurchasePrice) {
        this.newPurchasePrice = newPurchasePrice;
    }

    public String getNewVehicleModelName() {
        return newVehicleModelName;
    }

    public void setNewVehicleModelName(String newVehicleModelName) {
        this.newVehicleModelName = newVehicleModelName;
    }


    public String getNewVehicleMakeName() {
        return newVehicleMakeName;
    }

    public void setNewVehicleMakeName(String newVehicleMakeName) {
        this.newVehicleMakeName = newVehicleMakeName;
    }

    public List<Vehicle> getNewVehicleArray() {
        return newVehicleArray;
    }

    public void setNewVehicleArray(List<Vehicle> newVehicleArray) {
        this.newVehicleArray = newVehicleArray;
    }

    public List<VehicleModel> getNewModelArray() {
        return newModelArray;
    }

    public void setNewModelArray(List<VehicleModel> newModelArray) {
        this.newModelArray = newModelArray;
    }


//endregion


    @Override
    public String toString() {
        return "VehicleVO{" +
                "newYear=" + newYear +
                ", newLicensePlate='" + newLicensePlate + '\'' +
                ", newVIN='" + newVIN + '\'' +
                ", newColor='" + newColor + '\'' +
                ", newIsPurchased=" + newIsPurchased +
                ", newPurchasePrice=" + newPurchasePrice +
                ", newVehicleModelName='" + newVehicleModelName + '\'' +
                ", newVehicleArray=" + newVehicleArray +
                ", newVehicleMakeName='" + newVehicleMakeName + '\'' +
                ", newModelArray=" + newModelArray +
                '}';
    }
}
