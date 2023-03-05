package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {

    private final List<Food> foodStore;

    protected AbstractStore() {
        foodStore = new ArrayList<>();
    }

    @Override
    public boolean add(Food food) {
        boolean done = false;
        if (checkSuitability(food)) {
            foodStore.add(food);
            done = true;
        }
        return done;
    }

    @Override
    public List<Food> getFood() {
        return new ArrayList<>(foodStore);
    }

    @Override
    public void cleanStore() {
        foodStore.clear();
    }

    protected abstract boolean checkSuitability(Food food);

    protected float calculateRemainingShelfLife(Food food) {
        float expirationPeriod = Duration.between(food.getCreateDate(), food.getExpiryDate()).toDays();
        float daysExpired = Duration.between(food.getCreateDate(), LocalDateTime.now()).toDays();
        return (expirationPeriod - daysExpired) / expirationPeriod * 100;
    }

}