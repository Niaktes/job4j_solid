package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

public class Warehouse extends AbstractStore {

    @Override
    public boolean checkSuitability(Food food) {
        float remainingShelfLife = calculateRemainingShelfLife(food);
        return remainingShelfLife > 75;
    }

}