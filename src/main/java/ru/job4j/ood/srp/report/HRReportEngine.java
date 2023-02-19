package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.sorter.Sorter;
import ru.job4j.ood.srp.store.Store;

import java.util.List;
import java.util.function.Predicate;

public class HRReportEngine implements Report {

    private final Store store;
    private final Sorter sorter;

    public HRReportEngine(Store store, Sorter sorter) {
        this.store = store;
        this.sorter = sorter;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary; Currency;")
                .append(System.lineSeparator());
        List<Employee> employees = sorter.sortDescending(store.findBy(filter));
        for (Employee employee : employees) {
            text.append(employee.getName()).append(" ")
                    .append(employee.getSalary()).append(" ")
                    .append(employee.getCurrency())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

}