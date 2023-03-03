package ru.job4j.ood.lsp.parking;

public class PassengerCarParkingSpot implements ParkingSpot {

    private int id;
    private static final int CAPACITY = 1;
    private boolean isOccupied = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return CAPACITY;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PassengerCarParkingSpot that = (PassengerCarParkingSpot) o;
        if (id != that.id) {
            return false;
        }
        return isOccupied == that.isOccupied;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (isOccupied ? 1 : 0);
        return result;
    }

}