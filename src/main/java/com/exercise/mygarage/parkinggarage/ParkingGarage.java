package com.exercise.mygarage.parkinggarage;

import com.exercise.mygarage.base.ParkingType;
import com.exercise.mygarage.base.Status;
import com.exercise.mygarage.employee.Employee;
import com.exercise.mygarage.parkingspace.ParkingSpace;

import java.util.*;

/**
 * Created by agoel on 3/6/18.
 */
public class ParkingGarage {

    Map<ParkingType, List<ParkingSpace>> parkingSpaces = new HashMap<ParkingType, List<ParkingSpace>>();

    public ParkingGarage(int numberOfRegularParkingSpaces,
                         int numberOfReservedParkingSpaces,
                         int numberofHandicapParkingSpaces) {
        // create vacant parking spaces
        int parkingSpaceNumber = 0;
        List<ParkingSpace> regularParkingSpaces = new ArrayList<ParkingSpace>();
        for(int i = 0; i < numberOfRegularParkingSpaces; i++) {
            regularParkingSpaces.add(new ParkingSpace(parkingSpaceNumber++, ParkingType.REGULAR));
        }
        this.parkingSpaces.put(ParkingType.REGULAR, regularParkingSpaces);

        List<ParkingSpace> reservedParkingSpaces = new ArrayList<ParkingSpace>();
        for(int i = 0; i < numberOfReservedParkingSpaces; i++) {
            reservedParkingSpaces.add(new ParkingSpace(parkingSpaceNumber++, ParkingType.RESERVED));
        }
        this.parkingSpaces.put(ParkingType.RESERVED, reservedParkingSpaces);

        List<ParkingSpace> handicapParkingSpaces = new ArrayList<ParkingSpace>();
        for(int i = 0; i < numberofHandicapParkingSpaces; i++) {
            handicapParkingSpaces.add(new ParkingSpace(parkingSpaceNumber++, ParkingType.HANDICAP));
        }
        this.parkingSpaces.put(ParkingType.HANDICAP, handicapParkingSpaces);

    }

    public ParkingSpace findAndAllocateParking(ParkingType parkingType, Employee employee) {
        // parking space cannot be found if the parking type is not specified
        if (parkingType == null) {
            return null;
        }

        // find the first available parking space for the given parkingType
        Optional<ParkingSpace> optionalParkingSpace =
                parkingSpaces.get(parkingType)
                        .stream()
                        .filter(x -> Status.VACANT.equals(x.getStatus()))
                        .findFirst();

        if (optionalParkingSpace.get().isAvailable()) {
            ParkingSpace parkingSpace = optionalParkingSpace.get();
            parkingSpace.parkCar(employee);
            return parkingSpace;
        }

        return null;
    }

    public boolean isFull() {
        return isFull(ParkingType.ALL);
    }

    public boolean isFull(ParkingType parkingType) {
        GarageStatus garageStatus = null;
        switch (parkingType) {
            case REGULAR:
            case RESERVED:
            case HANDICAP:
                garageStatus = getStatusByType(parkingType);
                break;
            case ALL:
                garageStatus = getStatus().get(parkingType);
                break;
            default:
                return true;
        }

        if (garageStatus != null && garageStatus.getPercentageFull() == 100) {
            return true;
        }
        return false;
    }

    public GarageStatus getStatusByType(ParkingType parkingType) {
        long numberOfVacantParkingSpaces =
                parkingSpaces.get(parkingType)
                        .stream()
                        .filter(x -> Status.VACANT.equals(x.getStatus()))
                        .count();
        int numberOfParkingSpaces = parkingSpaces.get(parkingType).size();
        GarageStatus garageStatus =
                new GarageStatus(numberOfVacantParkingSpaces, numberOfParkingSpaces);
        return garageStatus;
    }

    public Map<ParkingType, GarageStatus> getStatus() {

        Map<ParkingType, GarageStatus> parkingTypeGarageStatusMap = new HashMap<ParkingType, GarageStatus>();

        // get the garage status for regular spaces
        GarageStatus regularGarageStatus = getStatusByType(ParkingType.REGULAR);
        parkingTypeGarageStatusMap.put(ParkingType.REGULAR, regularGarageStatus);

        // get the garage status for reserved spaces
        GarageStatus reservedGarageStatus = getStatusByType(ParkingType.RESERVED);
        parkingTypeGarageStatusMap.put(ParkingType.RESERVED, reservedGarageStatus);

        // get the garage status for handicap spaces
        GarageStatus handicapGarageStatus = getStatusByType(ParkingType.HANDICAP);
        parkingTypeGarageStatusMap.put(ParkingType.HANDICAP, handicapGarageStatus);

        GarageStatus allParkingGarageStatus = new GarageStatus(
                regularGarageStatus.getNumberOfVacantSpaces()
                        + reservedGarageStatus.getNumberOfVacantSpaces()
                        + handicapGarageStatus.getNumberOfVacantSpaces(),
                regularGarageStatus.getTotalNumberOfSpaces()
                        + reservedGarageStatus.getTotalNumberOfSpaces()
                        + handicapGarageStatus.getTotalNumberOfSpaces());
        parkingTypeGarageStatusMap.put(ParkingType.ALL, allParkingGarageStatus);

        return parkingTypeGarageStatusMap;
    }

    public
}

