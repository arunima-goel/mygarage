package com.exercise.mygarage.car;

/**
 * Created by agoel on 3/6/18.
 */
public class Car {
    private String make;
    private String model;
    private String licensePlaceNumber;
    private Boolean isParked = false;

    public Boolean getParked() {
        return isParked;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public String getLicensePlaceNumber() {
        return licensePlaceNumber;
    }

    public void park() {
        this.isParked = true;
    }

    public void move() {
        this.isParked = false;
    }

    public boolean isLicenseInState() {
        /*# License Plates
        # For insurance purposes, the company needs to be able to determine whether
        # a license plate is from in state or out of state. Luckily, in state license
        # license plate numbers use one of two very specific formats.
        #
        # Given a license plate     number, provide a way to determine if the plate is
        # from in state
        #
        # Old Format: <3 upper case letters> <hypen> <3-5 digits>
        # New Format: <3 upper case letters or digits> <space> <4 digits>
        #
        # Examples:
        # - 'ABC-123', 'XYZ-54321', 'MNO-4444'
        # - '9B2 1234', '222 9876', 'B1B 8887'*/
        return false;
    }
}
