package ru.job4j.ood.lsp.control;

import ru.job4j.ood.lsp.model.Food;
import ru.job4j.ood.lsp.store.AbstractStore;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class ControlQuality {

    private final List<AbstractStore> stores;

    public ControlQuality(List<AbstractStore> stores) {
        this.stores = stores;
    }

    public void sortFood(List<Food> foodToSort) {
        for (Food food : foodToSort) {
            float remainingShelfLife = calculateRemainingShelfLife(food);
            if (remainingShelfLife < 25) {
                setDiscountPrice(food);
            }
            for (AbstractStore store : stores) {
                if (store.checkSuitability(remainingShelfLife)) {
                   store.add(food);
                   break;
                }
            }
        }
    }

    private float calculateRemainingShelfLife(Food food) {
        float expirationPeriod = Duration.between(food.getCreateDate(), food.getExpiryDate()).toDays();
        float daysExpired = Duration.between(food.getCreateDate(), LocalDateTime.now()).toDays();
        return (expirationPeriod - daysExpired) / expirationPeriod * 100;
    }

    private void setDiscountPrice(Food food) {
        double oldPrice = food.getPrice();
        double discountValue = oldPrice * food.getDiscount() / 100;
        food.setPrice(oldPrice - discountValue);
    }

}