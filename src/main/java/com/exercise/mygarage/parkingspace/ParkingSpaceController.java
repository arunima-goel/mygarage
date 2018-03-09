package com.exercise.mygarage.parkingspace;

import com.exercise.mygarage.parkinggarage.ParkingGarageService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by agoel on 3/7/18.
 */
public class ParkingSpaceController {

    ParkingSpaceService parkingSpaceService;

    @RequestMapping("/getParkingSpaceStatus")
    public String scanBadge(@PathVariable String parkingSpaceNumber) {
        return parkingSpaceService.getStatus(parkingSpaceNumber);
    }

}
