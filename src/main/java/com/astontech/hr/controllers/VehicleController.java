package com.astontech.hr.controllers;

import com.astontech.hr.domain.*;
import com.astontech.hr.domain.VO.ElementVO;
import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;
import com.astontech.hr.services.VehicleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class VehicleController {

    private Logger log = Logger.getLogger(VehicleController.class);

    @Autowired
    VehicleMakeService vehicleMakeService;

    @Autowired
    VehicleModelService vehicleModelService;

    @Autowired
    VehicleService vehicleService;


    @RequestMapping(value="/admin/vehicle", method = RequestMethod.GET)
    public String adminHome(){
        return "admin/adminHome";
    }

    @RequestMapping(value = "/admin/vehicle/add", method = RequestMethod.GET)
    public String adminVehicleGet(Model model){
        model.addAttribute("vehicleVO", new VehicleVO());
        return "admin/vehicle/vehicle_add";
    }

    @RequestMapping(value = "/admin/vehicle/add", method = RequestMethod.POST)
    public String adminVehiclePost(VehicleVO vehicleVO, Model model){
        model.addAttribute("vehicleVO", new VehicleVO());


        boolean success = true;

        if(vehicleVO.getNewVehicleMakeName().isEmpty()){
            success = false;
        }
        if(vehicleVO.getNewVehicleModelName().isEmpty()){
            success = false;
        }
        if(vehicleVO.getNewYear() == 0){
            success = false;
        }
        if(vehicleVO.getNewLicensePlate().isEmpty()){
            success = false;
        }
        if(vehicleVO.getNewVIN().isEmpty()){
            success = false;
        }
        if(vehicleVO.getNewColor().isEmpty()){
            success = false;
        }
        if(vehicleVO.getNewPurchasePrice() == 0){
            success = false;
        }


        if(success) {
            model.addAttribute("successAlert", "visible");
            saveVehicleMakeAndModelFromVO(vehicleVO);

        }
        else
            model.addAttribute("warningAlert", "visible");

        return "admin/vehicle/vehicle_add";
    }

    @RequestMapping(value="/admin/vehicle/list/vehicles", method = RequestMethod.GET)
    public String adminVehicleList(Model model){



        model.addAttribute("makeList",  vehicleMakeService.listAllVehicleMakes());


        return "admin/vehicle/vehicle_list";
    }

    @RequestMapping(value="/admin/vehicle/list/models", method = RequestMethod.GET)
    public String adminModelList(Model model){



        model.addAttribute("modelList",  vehicleModelService.listAllVehicleModels());


        return "admin/vehicle/model_list";
    }

    @RequestMapping(value="/admin/vehicle/list/makes", method = RequestMethod.GET)
    public String adminMakeList(Model model){



        model.addAttribute("makeList",  vehicleMakeService.listAllVehicleMakes());


        return "admin/vehicle/make_list";
    }



    //Vehicle Editing
    @RequestMapping(value="/admin/vehicle/edit/{id}", method = RequestMethod.GET)
    public String vehicleTypeEdit(@PathVariable int id, Model model){

        Vehicle vehicle = vehicleService.getVehicleById(id);


        model.addAttribute("vehicle", vehicle);

        return "admin/vehicle/vehicle_edit";
    }

    @RequestMapping(value="/admin/vehicle/update", method = RequestMethod.POST)
    public String vehicleUpdate(Vehicle vehicle) {

        System.out.println("Vehicle Make: " + vehicle.toString());


        vehicleService.saveVehicle(vehicle);

        if(vehicle.getId() != null) {
            return "redirect:/admin/vehicle/edit/" + vehicle.getId();
        } else {
            return "admin/vehicle/vehicle_list";
        }
    }

    @RequestMapping(value="/admin/vehicle/delete/{id}", method = RequestMethod.GET)
    public String vehicleTypeDelete(@PathVariable int id){

        outer:
        for(VehicleModel vehicleModel: vehicleModelService.listAllVehicleModels()){
            for (Vehicle vehicle : vehicleModel.getVehicleList()) {
                if (vehicle.getId() == vehicleService.getVehicleById(id).getId()) {
                    vehicleModel.getVehicleList().remove(vehicle);
                    vehicleModelService.saveVehicleModel(vehicleModel);
                    break outer;
                } else {
                    continue;
                }
            }
        }

        vehicleService.delete(id);

        return "redirect:/admin/vehicle/list/vehicles";
    }


    //Model Editing
    @RequestMapping(value="/admin/vehicle/edit/model/{id}", method = RequestMethod.GET)
    public String modelEdit(@PathVariable int id, Model model){

        VehicleModel vehicleModel = vehicleModelService.getVehicleModelById(id);

        System.out.println("Model: " + vehicleModel.toString());

        model.addAttribute("vehicleModel", vehicleModel);

        return "admin/vehicle/model_edit";
    }

    @RequestMapping(value="/admin/vehicle/update/model", method = RequestMethod.POST)
    public String modelUpdate(VehicleModel vehicleModel) {

        System.out.println("Vehicle Make: " + vehicleModel.toString());

//        if(!newVehicle.equals("")){
//            if(vehicleModel.getVehicleList() == null){
//                List<Vehicle> vehicleList = new ArrayList<Vehicle>();
//                vehicleList.add(newVehicle);
//                vehicleModel.setVehicleList(vehicleList);
//            }else {
//               vehicleModel.getVehicleList().add(newVehicle);
//            }
//        }

        if(vehicleModel.getVehicleList() != null ) {
            for (int i = 0; i < vehicleModel.getVehicleList().size(); i++) {
                //see if string is empty
                if (vehicleModel.getVehicleList().get(i).getLicensePlate().equals("")) {
                    vehicleModel.getVehicleList().remove(i);
                }
            }
        }


        vehicleModelService.saveVehicleModel(vehicleModel);

        if(vehicleModel.getId() != null) {
            return "redirect:/admin/vehicle/edit/model/" + vehicleModel.getId();
        } else {
            return "admin/vehicle/model_list";
        }
    }

    @RequestMapping(value="/admin/vehicle/delete/model/{id}", method = RequestMethod.GET)
    public String modelDelete(@PathVariable int id){
        for(Vehicle vehicle: vehicleModelService.findVehicleList(vehicleModelService.getVehicleModelById(id).getVehicleModelName())){
           vehicleService.delete(vehicle.getId());
         }

        outer:
        for(VehicleMake vehicleMake: vehicleMakeService.listAllVehicleMakes()){
                for (VehicleModel vehicleModel : vehicleMake.getModelList()) {
                    if (vehicleModel.getId() == vehicleModelService.getVehicleModelById(id).getId()) {
                        vehicleMake.getModelList().remove(vehicleModel);
                        vehicleMakeService.saveVehicleMake(vehicleMake);
                        break outer;
                    } else {
                        continue;
                    }
                }
        }

        vehicleModelService.deleteModel(id);
        return "redirect:/admin/vehicle/list/models";
    }

    //Make Editing
    @RequestMapping(value="/admin/vehicle/edit/make/{id}", method = RequestMethod.GET)
    public String makeEdit(@PathVariable int id, Model model){


        VehicleMake vehicleMake = vehicleMakeService.getVehicleMakeById(id);


        model.addAttribute("vehicleMake", vehicleMake);

        return "admin/vehicle/make_edit";
    }

    @RequestMapping(value="/admin/vehicle/update/make", method = RequestMethod.POST)
    public String makeUpdate(VehicleMake vehicleMake,
                                @RequestParam("inputNewModel") String newModel) {


        if(!newModel.equals("")){
            if(vehicleMake.getModelList() == null){
                List<VehicleModel> modelList = new ArrayList<VehicleModel>();
                modelList.add(new VehicleModel(newModel));
                vehicleMake.setModelList(modelList);
                System.out.println("We think the list is null");
            }else {
                vehicleMake.getModelList().add(new VehicleModel(newModel));
                System.out.println("Vehicle Make: " + vehicleMake.toString() + vehicleMake.getModelList().toString());
            }
        }

//        if(vehicleMake.getModelList() != null ) {
//            for (int i = 0; i < vehicleMake.getModelList().size(); i++) {
//                //see if string is empty
//                if (vehicleMake.getModelList().get(i).getVehicleModelName().equals("")) {
//                    vehicleMake.getModelList().remove(i);
//                }
//            }
//        }


        vehicleMakeService.saveVehicleMake(vehicleMake);

        if(vehicleMake.getId() != null) {
            return "redirect:/admin/vehicle/edit/make/" + vehicleMake.getId();
        } else {
            return "admin/vehicle/lists/makes";
        }
    }

    @RequestMapping(value="/admin/vehicle/delete/make/{id}", method = RequestMethod.GET)
    public String makeDelete(@PathVariable int id){
        for(VehicleModel model: vehicleMakeService.getVehicleMakeById(id).getModelList()){
            for(Vehicle vehicle: model.getVehicleList()){
                vehicleService.delete(vehicle.getId());
            }
            vehicleModelService.deleteModel(model.getId());
        }

        vehicleMakeService.deleteMake(id);

        return "redirect:/admin/vehicle/list/makes";
    }


    private void saveVehicleMakeAndModelFromVO(VehicleVO vehicleVO){
        //assume that the vehicle is new
        Vehicle newVehicle = vehicleVO.hydrateVehicle();
        System.out.println("New Vehicle:" + newVehicle.toString());

        Boolean makeExists = false;
        Boolean modelExists = false;

        VehicleModel updateModel = null;
        VehicleMake updateMake = null;

        if(vehicleMakeService.getVehicleMakeById(1) == null){
            saveEverything(vehicleVO);
            System.out.println("First Item in Database");
        }else {  //check to see if a vehicle make of the same name exists
            outer:
            for (VehicleMake vehicleMake : vehicleMakeService.listAllVehicleMakes()) {
                //if it does
                System.out.println("Make Name: " +vehicleMake.getVehicleMakeName() + " VO Make Name: " + vehicleVO.getNewVehicleMakeName());
                if (vehicleMake.getVehicleMakeName().equals(vehicleVO.getNewVehicleMakeName())) {
                    //check to see if a model of the same name exists
                    updateMake = vehicleMake;
                    makeExists = true;
                    for (VehicleModel vehicleModel : vehicleModelService.listAllVehicleModels()) {
                        System.out.println("Model Name: " + vehicleModel.getVehicleModelName() + " VO Model Name:" + vehicleVO.getNewVehicleModelName());
                        if (vehicleModel.getVehicleModelName().equals(vehicleVO.getNewVehicleModelName())) {
                            //save vehicle to vehicle list and then model to model list
                            System.out.println("Match Model");
                            updateModel = vehicleModel;
                            modelExists = true;
                            System.out.println(modelExists);
                        }//if the make exists but the model does not
                        else {
                            continue;
                        }

                    }

                } else{
                    continue;
                }
            }
            System.out.println("MakeExists: " + makeExists + " ModelExists: " + modelExists);
            if(makeExists == true && modelExists == true){
                updateModel.getVehicleList().add(newVehicle);
                for(Vehicle vehicle: updateModel.getVehicleList()){
                    System.out.println("Vehicle: " + vehicle.toString() + " Model: " + updateModel.getVehicleModelName());
                }
                vehicleModelService.saveVehicleModel(updateModel);
                System.out.println("True and True");
            } else if(makeExists == true && modelExists == false){
                List<Vehicle> newVehicleList = new ArrayList<>();
                newVehicleList.add(newVehicle);
                VehicleModel newModel = new VehicleModel(vehicleVO.getNewVehicleModelName());
                newModel.setVehicleList(newVehicleList);
                updateMake.getModelList().add(newModel);
                System.out.println("true and false");
                vehicleMakeService.saveVehicleMake(updateMake);
            } else{
                saveEverything(vehicleVO);
                System.out.println("False and False");
            }
        }
   }

    private void saveEverything(VehicleVO vehicleVO){
        List<Vehicle> newVehicleList = new ArrayList<>();
        newVehicleList.add(vehicleVO.hydrateVehicle());


        VehicleModel newModel = new VehicleModel(vehicleVO.getNewVehicleModelName());
        newModel.setVehicleList(newVehicleList);

        List<VehicleModel> modelList = new ArrayList<>();
        modelList.add(newModel);



        VehicleMake newVehicleMake = new VehicleMake(vehicleVO.getNewVehicleMakeName(), modelList);
        System.out.println("Vehicle Make: " + newVehicleMake.toString() + newVehicleMake.getModelList().toString());
        vehicleMakeService.saveVehicleMake(newVehicleMake);
    }

    private Vehicle hydrateJustVehicle(VehicleVO vehicleVO){
        return vehicleVO.hydrateVehicle();
    }

}