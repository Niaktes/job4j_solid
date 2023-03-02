package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    @Test
    void whenRemainingShelfLifeMoreThenZeroAndLessThen75PercentThenSuitableIsTrue() {
        AbstractStore shop = new Shop();
        assertTrue(shop.checkSuitability(1.1f));
        assertTrue(shop.checkSuitability(74.5f));
    }

    @Test
    void whenRemainingShelfLifeLessThenZeroOrMoreThen75PercentThenSuitableIsFalse() {
        AbstractStore shop = new Shop();
        assertFalse(shop.checkSuitability(-1.0f));
        assertFalse(shop.checkSuitability(75.2f));
    }

}