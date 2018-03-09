package com.exercise.mygarage.parkinggarage;

/**
 * Created by agoel on 3/7/18.
 */
public class GarageStatus {
    private long numberOfOccupiedSpaces;
    private long numberOfVacantSpaces;
    private float percentageFull;
    private float percentageVacant;
    private long totalNumberOfSpaces;

    public long getTotalNumberOfSpaces() {
        return totalNumberOfSpaces;
    }

    public float getPercentageFull() {
        return percentageFull;
    }

    public long getNumberOfOccupiedSpaces() {
        return numberOfOccupiedSpaces;
    }

    public long getNumberOfVacantSpaces() {
        return numberOfVacantSpaces;
    }

    public float getPercentageVacant() {
        return percentageVacant;
    }


    public GarageStatus(long numberOfOccupiedSpaces, long totalNumberOfSpaces) {
        this.numberOfOccupiedSpaces = numberOfOccupiedSpaces;
        this.totalNumberOfSpaces = totalNumberOfSpaces;
        this.numberOfVacantSpaces = totalNumberOfSpaces - numberOfOccupiedSpaces;
        this.percentageVacant = 100 * this.numberOfVacantSpaces / (this.numberOfVacantSpaces + numberOfOccupiedSpaces);
        this.percentageFull = 100 * numberOfOccupiedSpaces / (this.numberOfVacantSpaces + numberOfOccupiedSpaces);
    }

}
