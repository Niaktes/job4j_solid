package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrashTest {

    @Test
    void whenRemainingShelfLifeMoreThenZeroPercentThenSuitableIsFalse() {
        Store trash = new Trash();
        assertFalse(trash.checkSuitability(1.1f));
    }

    @Test
    void whenRemainingShelfLifeLessThenZeroPercentThenSuitableIsTrue() {
        Store trash = new Trash();
        assertTrue(trash.checkSuitability(0.0f));
        assertTrue(trash.checkSuitability(-1.1f));
    }

}