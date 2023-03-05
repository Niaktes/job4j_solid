package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    private final List<ParkingSpot> spots;
    private final List<Car> parkedCars;
    private int passengerCarSpots;
    private int truckSpots;

    public Parking(int passengerCarSpots, int truckSpots) {
        this.passengerCarSpots = passengerCarSpots;
        this.truckSpots = truckSpots;
        spots = new ArrayList<>();
        parkedCars = new ArrayList<>();
        for (int i = 0; i < passengerCarSpots; i++) {
            spots.add(new PassengerCarParkingSpot(i));
        }
        for (int i = 0; i < truckSpots; i++) {
            spots.add(new TruckParkingSpot(i, 5));
        }
    }

    public boolean park(Car car) {
        boolean done = false;
        int carSize = car.getSize();

        if (carSize == 1 && passengerCarSpots > 0) {
            for (ParkingSpot spot : spots) {
                if (spot.getCapacity() == 1 && !spot.isOccupied()) {
                    spot.setOccupied(true);
                    passengerCarSpots--;
                    break;
                }
            }
            parkedCars.add(car);
            done = true;

        } else if (carSize > 1 && truckSpots > 0) {
            for (ParkingSpot spot : spots) {
                if (spot.getCapacity() > 1 && !spot.isOccupied()) {
                    spot.setOccupied(true);
                    truckSpots--;
                    break;
                }
            }
            parkedCars.add(car);
            done = true;

        } else if (carSize > 1 && truckSpots == 0 && passengerCarSpots >= carSize) {
            for (int i = 0; i < spots.size(); i++) {
                if (spots.get(i).getCapacity() == 1 && !spots.get(i).isOccupied()) {
                    boolean truckWillFit = true;
                    for (ParkingSpot spot : spots.subList(i, i + carSize)) {
                        if (spot.isOccupied()) {
                            truckWillFit = false;
                        }
                    }
                    if (truckWillFit) {
                        for (ParkingSpot spot : spots.subList(i, i + carSize)) {
                            spot.setOccupied(true);
                        }
                        passengerCarSpots -= carSize;
                        parkedCars.add(car);
                        done = true;
                        break;
                    }
                }
            }
        }

        return done;
    }

}