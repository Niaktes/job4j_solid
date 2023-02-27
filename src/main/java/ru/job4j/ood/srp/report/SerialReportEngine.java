package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.serializer.Serializer;
import ru.job4j.ood.srp.store.Store;

import java.util.function.Predicate;

public class SerialReportEngine implements Report {

    private final Store store;
    private final Serializer<Employee> serializer;

    public SerialReportEngine(Store store, Serializer<Employee> serializer) {
        this.store = store;
        this.serializer = serializer;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return serializer.serialize(store.findBy(filter));
    }

}