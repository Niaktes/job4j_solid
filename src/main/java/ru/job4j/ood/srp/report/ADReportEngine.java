package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.currency.*;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class ADReportEngine implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private final CurrencyConverter converter;
    private final Currency targetCurrency;

    public ADReportEngine(Store store, DateTimeParser<Calendar> dateTimeParser, CurrencyConverter converter, Currency currency) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.converter = converter;
        this.targetCurrency = currency;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append(String.format("Name; Hired; Fired; Salary in %s;", targetCurrency))
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(" ")
                    .append(dateTimeParser.parse(employee.getHired())).append(" ")
                    .append(dateTimeParser.parse(employee.getFired())).append(" ")
                    .append(converter.convert(employee.getCurrency(), employee.getSalary(), targetCurrency))
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

}
