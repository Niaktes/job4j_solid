package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;

public class MaxMin {

    public <T> T max(List<T> values, Comparator<T> comparator) {
        return values.isEmpty() ? null : findMaxMin(values, comparator, x -> x > 0);
    }

    public <T> T min(List<T> values, Comparator<T> comparator) {
        return values.isEmpty() ? null : findMaxMin(values, comparator, x -> x < 0);
    }

    private <T> T findMaxMin(List<T> values, Comparator<T> comparator, IntPredicate predicate) {
        T result = values.get(0);
        for (T value : values) {
            if (predicate.test(comparator.compare(value, result))) {
                result = value;
            }
        }
        return result;
    }

}
