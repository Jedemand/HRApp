package com.astontech.hr.bootstrap;


import com.astontech.hr.domain.*;
import com.astontech.hr.services.ElementService;
import com.astontech.hr.services.ElementTypeService;
import com.astontech.hr.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ElementService elementService;

    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    VehicleMakeService vehicleMakeService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<Vehicle> BuickList = new ArrayList<>();
        BuickList.add(new Vehicle(1996, "857-PJK", "JN5674DN9", "Green", true, 8500));
        BuickList.add(new Vehicle(2010, "506-MNY", "NW53467G9", "Silver", true, 10500));
        BuickList.add(new Vehicle(1996, "857-PJK", "HT46781P6", "Black", true, 850));

        List<Vehicle> ChevyList = new ArrayList<>();
        ChevyList.add(new Vehicle(1996, "P84-53Y", "1D7HL42N53S102080", "White", true, 8500));
        ChevyList.add(new Vehicle(2010, "7B8-6M3", "2GTEK13M081179189", "Gray", true, 10500));
        ChevyList.add(new Vehicle(1996, "CWT-166", "1G11C5SA5DU149624", "Red", true, 850));

        List<VehicleModel> gmList = new ArrayList<>();
        gmList.add(new VehicleModel("Buick", BuickList));
        gmList.add(new VehicleModel("Chevy", ChevyList));

        VehicleMake GM = new VehicleMake("GM", gmList);

        vehicleMakeService.saveVehicleMake(GM);
    }

    private void generateElementAndElementTypes(){
        ElementType laptopType = new ElementType("Laptop");

        List<Element> elementList = new ArrayList<>();
        elementList.add(new Element("Acer"));
        elementList.add(new Element("Dell"));
        elementList.add(new Element("Samsung"));
        elementList.add(new Element("Apple"));
        elementList.add(new Element("Asus"));

        laptopType.setElementList(elementList);

        elementTypeService.saveElementType(laptopType);


        ElementType emailType = new ElementType("Email");

        List<Element> emailList = new ArrayList<>();
        emailList.add(new Element("Work"));
        emailList.add(new Element("Personal"));
        emailList.add(new Element("Internal"));

        emailType.setElementList(elementList);

        elementTypeService.saveElementType(emailType);

    }


}
