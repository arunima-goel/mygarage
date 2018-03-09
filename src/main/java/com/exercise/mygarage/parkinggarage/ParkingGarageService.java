package com.exercise.mygarage.parkinggarage;

import com.exercise.mygarage.base.ParkingType;
import com.exercise.mygarage.parkingspace.ParkingSpace;

import java.util.List;

/**
 * Created by agoel on 3/7/18.
 */
public class ParkingGarageService {

    public String scanBadge(String employeeId,
                            String licensePlateNumber,
                            String parkingType) {
        // check if there is a parking spot available - if yes, return the lot number. If not, return an indicator for full garage
        // check if car is already parked -> then release the spot
        return null;
    }

    public boolean isGarageFull(String parkingType) {
        // if parking type is null or ANY -> do not use parking type
        return false;
    }

    public GarageStatus getGarageStatus(ParkingType parkingType) {
        return null;
    }

    public GarageStatus getGarageStatus() {
        return getGarageStatus(null);
    }

    public List<GarageStatus> getGarageStatusOverall() {
        // TODO: Go over all parking types and get status
        return null;
    }

    public ParkingSpace whereIsCarParked(String employeeId) {
        return null;
    }
}
