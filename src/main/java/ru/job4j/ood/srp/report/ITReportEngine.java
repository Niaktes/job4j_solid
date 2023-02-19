package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class ITReportEngine implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private final String separator;

    public ITReportEngine(Store store, DateTimeParser<Calendar> dateTimeParser, String separator) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.separator = separator;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append(String.format("Name%1$sHired%1$sFired%1$sSalary%1$sCurrency", separator))
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(separator)
                    .append(dateTimeParser.parse(employee.getHired())).append(separator)
                    .append(dateTimeParser.parse(employee.getFired())).append(separator)
                    .append(employee.getSalary()).append(separator)
                    .append(employee.getCurrency())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

}