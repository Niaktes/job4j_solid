package ru.job4j.ood.lsp.parking;

public class TruckParkingSpot implements ParkingSpot {

    private int id;
    private final int capacity;
    private boolean isOccupied = false;

    public TruckParkingSpot(int capacity) {
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
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
        TruckParkingSpot that = (TruckParkingSpot) o;
        if (id != that.id) {
            return false;
        }
        if (capacity != that.capacity) {
            return false;
        }
        return isOccupied == that.isOccupied;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + capacity;
        result = 31 * result + (isOccupied ? 1 : 0);
        return result;
    }

}