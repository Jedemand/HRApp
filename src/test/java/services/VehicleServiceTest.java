package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;
import com.astontech.hr.services.VehicleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class VehicleServiceTest {
    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Test
    public void testSave(){
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

        assertEquals("White", vehicleService.getVehicleById(4).getColor());
        assertEquals("Green", vehicleService.getVehicleById(1).getColor());
        assertEquals("Chevy", vehicleModelService.getVehicleModelById(2).getVehicleModelName());
        assertEquals("GM", vehicleMakeService.getVehicleMakeById(1).getVehicleMakeName());


        for(Vehicle vehicle: vehicleModelService.findAllVehicleList()){
            System.out.println(vehicle.toString());
        }

        for (VehicleMake make:vehicleMakeService.listAllVehicleMakes()){
            for(VehicleModel model: make.getModelList()){
                for(Vehicle vehicle: model.getVehicleList()){
                    System.out.println("Vehicle " + vehicle.toString() + " Model: " + model.getVehicleModelName() + " Make: " + make.getVehicleMakeName());
                }
            }
        }

        vehicleService.delete(6);
        assertEquals(null, vehicleService.getVehicleById(6));

    }

    @Test
    public void edit(){

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

        VehicleModel vehicleModel =vehicleModelService.getVehicleModelById(1);

        for(int i=0; i < vehicleModel.getVehicleList().size(); i++){
            //see if string is empty
            System.out.println(vehicleModel.getVehicleList().get(i).toString());
            if(vehicleModel.getVehicleList().get(i).getLicensePlate().equals("")){
                vehicleModel.getVehicleList().remove(i);
            }
        }
    }

    @Test
    public void testFind(){


        vehicleService.listAllVehicles();
        vehicleModelService.listAllVehicleModels();

    }

    @Test public void testGetList(){
        vehicleMakeService.findModelList("GM");
        vehicleModelService.findVehicleList("Chevy");
    }


}
