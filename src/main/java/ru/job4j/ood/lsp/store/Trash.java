package ru.job4j.ood.lsp.store;

public class Trash extends AbstractStore {

    @Override
    public boolean checkSuitability(float remainingShelfLife) {
        return remainingShelfLife <= 0;
    }

}