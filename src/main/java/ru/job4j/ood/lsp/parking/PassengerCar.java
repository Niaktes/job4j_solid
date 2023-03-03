package ru.job4j.ood.lsp.parking;

public class PassengerCar implements Car {

    private int id;
    private static final int SIZE = 1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return SIZE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PassengerCar that = (PassengerCar) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

}