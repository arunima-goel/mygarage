package com.exercise.mygarage.parkingspace;

import com.exercise.mygarage.base.ParkingType;
import com.exercise.mygarage.base.Status;
import com.exercise.mygarage.car.Car;
import com.exercise.mygarage.employee.Employee;

/**
 * Created by agoel on 3/6/18.
 */
public class ParkingSpace {
    //What type should an ID be? Self allocated - needs to be human readable and most likely printed on the spot
    int parkingSpaceNumber;
    ParkingType parkingType;
    Status status;

    // Assuming there is only one car registered per employee. Otherwise we will store car here.
    Employee employee;

    public int getParkingSpaceNumber() {
        return parkingSpaceNumber;
    }

    public Status getStatus() {
        return status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public ParkingType getParkingType() {
        return parkingType;
    }

    public ParkingSpace(int parkingSpaceNumber, ParkingType parkingType) {
        this.parkingSpaceNumber = parkingSpaceNumber;
        this.parkingType = parkingType;
        this.status = Status.VACANT;
        this.employee = null;
    }

    public Employee whoIsParked() {
        return employee;
    }

    public boolean isAvailable() {
        return !(status.compareTo(Status.OCCUPIED) == 0);
    }

    public void parkCar(Employee employee) {
        this.employee = employee;
        this.employee.getCar().park();
        this.status = Status.OCCUPIED;
    }

    public void releaseSpace() {
        this.employee.getCar().move();
        this.employee =null;
        this.status = Status.VACANT;
    }
}
