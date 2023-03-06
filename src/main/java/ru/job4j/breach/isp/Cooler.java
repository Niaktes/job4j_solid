package ru.job4j.breach.isp;

public interface Cooler {

    void pourColdWater();

    void pourHotWater();

    void purifyWater();

    boolean putNewBottle();

}

class OfficeCooler implements Cooler {

    @Override
    public void pourColdWater() {
        /*
         */
    }

    @Override
    public void pourHotWater() {
        /*
         */
    }

    @Override
    public void purifyWater() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean putNewBottle() {
        throw new UnsupportedOperationException();
    }

}

class Purifyer implements Cooler {

    @Override
    public void pourColdWater() {
        /*
         */
    }

    @Override
    public void pourHotWater() {
        /*
         */
    }

    @Override
    public void purifyWater() {
        /*
         */
    }

    @Override
    public boolean putNewBottle() {
        return true;
    }

}

/*
В интерфейсе кулер есть методы, которые относятся к пурифайеру (частный вариант кулера), но не могут быть реализованы в кулере, и наоборот.
 */
