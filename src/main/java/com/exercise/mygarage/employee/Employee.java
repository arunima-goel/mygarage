package com.exercise.mygarage.employee;

import com.exercise.mygarage.base.ParkingType;
import com.exercise.mygarage.car.Car;

/**
 * Created by agoel on 3/6/18.
 */
public class Employee {
    // TODO: 4 character hexadecimal string
    /* # com.exercise.mygarage.employee.Employee IDs
    # While the badge reader provides hexadecimal employee IDs, all other systems
    # use a specific format for employee IDs. com.exercise.mygarage.employee.Employee IDs need to be returned by
    # your software as a decimal representation with a hyphen, '-', separating each
    # 4 bits.
    # Example: ABCD -> 10-11-12-13

    */
    private String employeeId;
    private ParkingType parkingType;
    private Car car;

    public ParkingType getParkingType() {
        return parkingType;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Car getCar() {
        return car;
    }

}
