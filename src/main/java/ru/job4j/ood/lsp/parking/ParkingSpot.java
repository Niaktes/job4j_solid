package ru.job4j.ood.lsp.parking;

public interface ParkingSpot {

    int getId();

    int getCapacity();

    boolean isOccupied();

    void setOccupied(boolean occupied);

}