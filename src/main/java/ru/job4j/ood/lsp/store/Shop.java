package ru.job4j.ood.lsp.store;

public class Shop extends AbstractStore {

    @Override
    public boolean checkSuitability(float remainingShelfLife) {
        return remainingShelfLife <= 75 && remainingShelfLife > 0;
    }

}