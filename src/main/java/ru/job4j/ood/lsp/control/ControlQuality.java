package ru.job4j.ood.lsp.control;

import ru.job4j.ood.lsp.model.Food;
import ru.job4j.ood.lsp.store.AbstractStore;

import java.util.List;

public class ControlQuality {

    private final List<AbstractStore> stores;

    public ControlQuality(List<AbstractStore> stores) {
        this.stores = stores;
    }

    public void sortFood(List<Food> foodToSort) {
        for (Food food : foodToSort) {
            for (AbstractStore store : stores) {
                if (store.add(food)) {
                   break;
                }
            }
        }
    }

}