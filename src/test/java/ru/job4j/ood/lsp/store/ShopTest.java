package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.model.Food;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    @Test
    void whenRemainingShelfLifeMoreThenZeroAndLessThen75PercentThenSuitableIsTrue() {
        AbstractStore shop = new Shop();
        LocalDateTime now = LocalDateTime.now();
        Food corn = new Food("Corn", now.plusDays(7), now.minusDays(3), 100, 25);
        Food fish = new Food("Fish", now.plusDays(1), now.minusDays(9), 1000, 25);
        assertTrue(shop.checkSuitability(corn));
        assertTrue(shop.checkSuitability(fish));
    }

    @Test
    void whenRemainingShelfLifeLessThenZeroOrMoreThen75PercentThenSuitableIsFalse() {
        AbstractStore shop = new Shop();
        LocalDateTime now = LocalDateTime.now();
        Food corn = new Food("Corn", now.minusDays(1), now.minusDays(11), 100, 25);
        Food fish = new Food("Fish", now.plusDays(10), now.minusDays(1), 1000, 25);
        assertFalse(shop.checkSuitability(corn));
        assertFalse(shop.checkSuitability(fish));
    }

    @Test
    void whenFoodNotSoFreshThenPriceReduced() {
        AbstractStore shop = new Shop();
        LocalDateTime now = LocalDateTime.now();
        Food corn = new Food("Corn", now.plusDays(2), now.minusDays(8), 100, 25);
        Food fish = new Food("Fish", now.plusDays(5), now.minusDays(5), 1000, 50);
        shop.add(corn);
        shop.add(fish);
        assertEquals(75f, corn.getPrice());
        assertEquals(1000f, fish.getPrice());
    }

}