package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    private final List<ParkingSpot> spots;
    private final int passengerCarSpots;
    private final int truckSpots;

    public Parking(int passengerCarSpots, int truckSpots) {
        this.passengerCarSpots = passengerCarSpots;
        this.truckSpots = truckSpots;
        spots = new ArrayList<>();
        for (int i = 0; i < passengerCarSpots; i++) {
            spots.add(new PassengerCarParkingSpot());
        }
        for (int i = 0; i < truckSpots; i++) {
            spots.add(new TruckParkingSpot(5));
        }
    }

    public boolean park(Car car) {
        return false;
    }

}