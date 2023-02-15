package ru.job4j.kiss;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class MaxMinTest {

    MaxMin maxMin;

    @BeforeEach
    void init() {
        maxMin = new MaxMin();
    }

    @Test
    void whenComparingIntegersThenMaxAndMinFound() {
        List<Integer> values = Arrays.asList(6, 18, 35, 999, -8, 999, 0, -683, 3);
        Comparator<Integer> comparator = Comparator.naturalOrder();
        assertEquals(-683, maxMin.min(values, comparator));
        assertEquals(999, maxMin.max(values, comparator));
    }

    @Test
    void whenComparingStringsLengthThenMaxAndMinFound() {
        List<String> values = Arrays.asList("здесь", "был", "Вася", "и", "Вениамин Семенович");
        Comparator<String> comparator = Comparator.comparingInt(String :: length);
        assertEquals("и", maxMin.min(values, comparator));
        assertEquals("Вениамин Семенович", maxMin.max(values, comparator));
    }

}
