package ru.job4j.ood.srp.sorter;

import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.model.Employee;

import java.util.Comparator;
import java.util.List;

public class SalarySorter implements Sorter {

    @Override
    public List<Employee> sortAscending(List<Employee> employees) {
        return sort(employees, Comparator.naturalOrder());
    }

    @Override
    public List<Employee> sortDescending(List<Employee> employees) {
        return sort(employees, Comparator.reverseOrder());
    }

    private List<Employee> sort(List<Employee> employees, Comparator<Double> comparator) {
        CurrencyConverter currencyConverter = new InMemoryCurrencyConverter();
        return employees.stream()
                .sorted((e1, e2) -> {
                    Double first = currencyConverter.convert(e1.getCurrency(), e1.getSalary(), Currency.RUB);
                    Double second = currencyConverter.convert(e2.getCurrency(), e2.getSalary(), Currency.RUB);
                    return comparator.compare(first, second);
                })
                .toList();
    }

}