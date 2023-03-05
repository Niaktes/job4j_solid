package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.model.Food;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TrashTest {

    @Test
    void whenRemainingShelfLifeMoreThenZeroPercentThenSuitableIsFalse() {
        AbstractStore trash = new Trash();
        LocalDateTime now = LocalDateTime.now();
        Food corn = new Food("Corn", now.plusDays(1), now.minusDays(10), 100, 25);
        assertFalse(trash.checkSuitability(corn));
    }

    @Test
    void whenRemainingShelfLifeLessThenZeroPercentThenSuitableIsTrue() {
        AbstractStore trash = new Trash();
        LocalDateTime now = LocalDateTime.now();
        Food corn = new Food("Corn", now, now.minusDays(10), 100, 25);
        assertTrue(trash.checkSuitability(corn));
    }

}