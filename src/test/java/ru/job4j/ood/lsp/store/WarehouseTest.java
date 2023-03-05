package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.model.Food;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {

    @Test
    void whenRemainingShelfLifeMoreThen75PercentThenSuitableIsTrue() {
        AbstractStore warehouse = new Warehouse();
        LocalDateTime now = LocalDateTime.now();
        Food corn = new Food("Corn", now.plusDays(9), now.minusDays(1), 100, 25);
        assertTrue(warehouse.checkSuitability(corn));
    }

    @Test
    void whenRemainingShelfLifeLessThen75PercentThenSuitableIsFalse() {
        AbstractStore warehouse = new Warehouse();
        LocalDateTime now = LocalDateTime.now();
        Food potato = new Food("Potato", now.plusDays(5), now.minusDays(5), 10, 50);
        assertFalse(warehouse.checkSuitability(potato));
    }

}