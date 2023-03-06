package ru.job4j.breach.isp;

public interface WashingMachine {

    boolean washClothes();

    boolean dryClothes();

}

class SimpleWashingMachine implements WashingMachine {

    @Override
    public boolean washClothes() {
        return false;
    }

    @Override
    public boolean dryClothes() {
        throw new UnsupportedOperationException();
    }

}

class ExpensiveWashingMachine implements WashingMachine {

    @Override
    public boolean washClothes() {
        return false;
    }

    @Override
    public boolean dryClothes() {
        return false;
    }

}

/*
Далеко не все стиральные машинки имеют встроенную функцию сушки белья.
 */
