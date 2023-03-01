package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {

    private final List<Food> foodStore;

    protected AbstractStore() {
        foodStore = new ArrayList<>();
    }

    @Override
    public boolean add(Food food) {
        return foodStore.add(food);
    }

    @Override
    public List<Food> getFood() {
        return foodStore;
    }

    @Override
    public boolean cleanStore() {
        foodStore.clear();
        return true;
    }

}