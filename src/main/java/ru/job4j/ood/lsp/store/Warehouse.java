package ru.job4j.ood.lsp.store;

public class Warehouse extends AbstractStore {

    @Override
    public boolean checkSuitability(float remainingShelfLife) {
        return remainingShelfLife > 75;
    }

}