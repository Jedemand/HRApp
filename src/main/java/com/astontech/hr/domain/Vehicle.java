package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vehicle_id")
    private Integer Id;

    @Version
    private Integer version;

    private int Year;
    private String LicensePlate;
    private String VIN;
    private String Color;
    private boolean purchased;
    private int PurchasePrice;
    //private Date PurchaseDate;


    //region


    public Vehicle() {
    }

    public Vehicle(int year, String licensePlate, String VIN, String color, boolean purchased, int purchasePrice) {
        Year = year;
        LicensePlate = licensePlate;
        this.VIN = VIN;
        Color = color;
        purchased = purchased;
        PurchasePrice = purchasePrice;
    }


    //endregion


    //region

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

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getLicensePlate() {
        return LicensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        LicensePlate = licensePlate;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public boolean purchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        purchased = purchased;
    }

    public int getPurchasePrice() {
        return PurchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        PurchasePrice = purchasePrice;
    }

//    public Date getPurchaseDate() {
//        return PurchaseDate;
//    }
//
//    public void setPurchaseDate(Date purchaseDate) {
//        PurchaseDate = purchaseDate;
//    }


    //endregion

    @Override
    public String toString() {
        return "Vehicle{" +
                "Id=" + Id +
                ", version=" + version +
                ", Year=" + Year +
                ", LicensePlate='" + LicensePlate + '\'' +
                ", VIN='" + VIN + '\'' +
                ", Color='" + Color + '\'' +
                ", Purchased=" + purchased +
                ", PurchasePrice=" + PurchasePrice +
                '}';
    }
}
