package com.exercise.mygarage.parkinggarage;

import com.exercise.mygarage.base.ParkingType;
import com.exercise.mygarage.parkingspace.ParkingSpace;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by agoel on 3/7/18.
 */
public class ParkingGarageController {

    ParkingGarageService parkingGarageService;

    //TODO: what will the return type be? It will be either the parking lot number or an indicator that the parking is full for that type
    @RequestMapping("/scanbadge")
    public String scanBadge(@PathVariable String employeeId,
                          @PathVariable String licensePlateNumber,
                          @PathVariable String parkingType) {
        return parkingGarageService.scanBadge(employeeId, licensePlateNumber, parkingType);
    }

    //TODO: can be divided into two like garage status and by type
    @RequestMapping("/isFull")
    public boolean isGarageFull(@PathVariable String parkingType) {
        return parkingGarageService.isGarageFull(parkingType);
    }

    @RequestMapping("/getStatus")
    public GarageStatus getGarageStatus(@PathVariable String parkingType) {
        return parkingGarageService.getGarageStatus();
    }

    @RequestMapping("/getStatusByType")
    public GarageStatus getGarageStatusByType(@PathVariable String parkingType) {
        return parkingGarageService.getGarageStatus(ParkingType.valueOf(parkingType));
    }

    @RequestMapping("/getGarageStatusPercentage")
    public GarageStatus getGarageStatusPercentage(@PathVariable String parkingType) {
        return parkingGarageService.getGarageStatus(ParkingType.valueOf(parkingType));
    }

    @RequestMapping("/getGarageStatusOverall")
    public List<GarageStatus> getGarageStatusOverall() {
        return parkingGarageService.getGarageStatusOverall();
    }

    //TODO: maybe?
    @RequestMapping("/whereiscarparked")
    public ParkingSpace whereIsCarParked(@PathVariable String employeeId) {
        return parkingGarageService.whereIsCarParked(employeeId);
    }
}
