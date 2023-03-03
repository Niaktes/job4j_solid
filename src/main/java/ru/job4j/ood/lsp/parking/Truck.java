package ru.job4j.ood.lsp.parking;

public class Truck implements Car {

    private int id;
    private final int size;

    public Truck(int size) {
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Truck truck = (Truck) o;
        if (id != truck.id) {
            return false;
        }
        return size == truck.size;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + size;
        return result;
    }

}