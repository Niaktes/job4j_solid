package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {

    @Test
    void whenRemainingShelfLifeMoreThen75PercentThenSuitableIsTrue() {
        Store warehouse = new Warehouse();
        assertTrue(warehouse.checkSuitability(75.1f));
    }

    @Test
    void whenRemainingShelfLifeLessThen75PercentThenSuitableIsFalse() {
        Store warehouse = new Warehouse();
        assertFalse(warehouse.checkSuitability(74.9f));
    }

}