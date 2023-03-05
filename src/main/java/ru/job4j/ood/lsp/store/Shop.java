package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

public class Shop extends AbstractStore {

    @Override
    public boolean checkSuitability(Food food) {
        float remainingShelfLife = calculateRemainingShelfLife(food);
        return remainingShelfLife <= 75 && remainingShelfLife > 0;
    }

    @Override
    public boolean add(Food food) {
        boolean suitable = super.add(food);
        if (suitable && calculateRemainingShelfLife(food) < 25) {
            setDiscountPrice(food);
        }
        return suitable;
    }

    private void setDiscountPrice(Food food) {
        double oldPrice = food.getPrice();
        double discountValue = oldPrice * food.getDiscount() / 100;
        food.setPrice(oldPrice - discountValue);
    }

}