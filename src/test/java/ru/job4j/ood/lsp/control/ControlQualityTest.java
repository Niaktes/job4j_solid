package ru.job4j.ood.lsp.control;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.model.Food;
import ru.job4j.ood.lsp.store.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControlQualityTest {

    @Test
    void whenFoodFreshThenItPlacedInWarehouse() {
        AbstractStore warehouse = new Warehouse();
        ControlQuality control = new ControlQuality(List.of(warehouse));
        LocalDateTime now = LocalDateTime.now();
        Food corn = new Food("Corn", now.plusDays(9), now.minusDays(1), 100, 25);
        Food fish = new Food("Fish", now.plusDays(11), now.minusDays(1), 1000, 25);
        Food potato = new Food("Potato", now.plusDays(5), now.minusDays(5), 10, 50);
        List<Food> expected = List.of(corn, fish);
        control.sortFood(List.of(corn, fish, potato));
        assertEquals(expected, warehouse.getFood());
    }

    @Test
    void whenFoodReadyToSellThenItPlacedInShop() {
        AbstractStore shop = new Shop();
        ControlQuality control = new ControlQuality(List.of(shop));
        LocalDateTime now = LocalDateTime.now();
        Food salad = new Food("Salad", now.plusDays(9), now, 700, 10);
        Food corn = new Food("Corn", now.plusDays(7), now.minusDays(3), 100, 25);
        Food fish = new Food("Fish", now.plusDays(5), now.minusDays(5), 1000, 25);
        Food potato = new Food("Potato", now.minusDays(1), now.minusDays(10), 10, 50);
        List<Food> expected = List.of(corn, fish);
        control.sortFood(List.of(salad, corn, fish, potato));
        assertEquals(expected, shop.getFood());
    }

    @Test
    void whenFoodRottenThenItPlacedInTrash() {
        AbstractStore trash = new Trash();
        ControlQuality control = new ControlQuality(List.of(trash));
        LocalDateTime now = LocalDateTime.now();
        Food salad = new Food("Salad", now.plusDays(9), now, 700, 10);
        Food corn = new Food("Corn", now.minusDays(1), now.minusDays(10), 100, 25);
        Food fish = new Food("Fish", now.minusDays(2), now.minusDays(9), 1000, 25);
        List<Food> expected = List.of(corn, fish);
        control.sortFood(List.of(salad, corn, fish));
        assertEquals(expected, trash.getFood());
    }

}