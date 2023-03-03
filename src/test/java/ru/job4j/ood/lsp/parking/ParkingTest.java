package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingTest {

    @Test
    void whenEnoughSpotsThenCarsParkedWell() {
        Car firstPassengerCar = new PassengerCar();
        Car secondPassengerCar = new PassengerCar();
        Car firstTruck = new Truck(3);
        Car secondTruck = new Truck(3);
        List<Car> cars = List.of(firstPassengerCar, secondPassengerCar, firstTruck, secondTruck);
        Parking parking = new Parking(3, 3);
        cars.forEach(car -> assertTrue(parking.park(car)));
    }

    @Test
    void whenNotEnoughSpotsThenCarsParkFalls() {
        Car firstPassengerCar = new PassengerCar();
        Car secondPassengerCar = new PassengerCar();
        Car firstTruck = new Truck(3);
        Car secondTruck = new Truck(3);
        Parking parking = new Parking(1, 1);
        parking.park(firstPassengerCar);
        parking.park(firstTruck);
        assertFalse(parking.park(secondPassengerCar));
        assertFalse(parking.park(secondTruck));
    }

    @Test
    void whenNotEnoughPassengerCarSpotsThenPassengerCarsParkFalls() {
        Car firstPassengerCar = new PassengerCar();
        Car secondPassengerCar = new PassengerCar();
        Car firstTruck = new Truck(3);
        Car secondTruck = new Truck(3);
        Parking parking = new Parking(1, 3);
        parking.park(firstPassengerCar);
        parking.park(firstTruck);
        assertFalse(parking.park(secondPassengerCar));
        assertTrue(parking.park(secondTruck));
    }

    @Test
    void whenNotEnoughTruckCarSpotsThenTruckCarsParkOnPassengerCarSpot() {
        Car firstPassengerCar = new PassengerCar();
        Car secondPassengerCar = new PassengerCar();
        Car firstTruck = new Truck(3);
        Car secondTruck = new Truck(3);
        Parking parking = new Parking(4, 1);
        parking.park(firstPassengerCar);
        parking.park(firstTruck);
        assertTrue(parking.park(secondTruck));
        assertFalse(parking.park(secondPassengerCar));
    }

}