package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.sorter.SalarySorter;
import ru.job4j.ood.srp.sorter.Sorter;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HRReportEngineTest {

    @Test
    void whenHRReportGeneratedThenOrderedAndTextWithoutDates() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee poorWorker = new Employee("Jorge", now, now, 100, Currency.USD);
        Employee richWorker = new Employee("Jack", now, now, 100, Currency.EUR);
        Sorter sorter = new SalarySorter();
        store.add(poorWorker);
        store.add(richWorker);
        Report engine = new HRReportEngine(store, sorter);
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary; Currency;")
                .append(System.lineSeparator())
                .append("Jack").append(" ")
                .append("100.0").append(" ")
                .append("EUR")
                .append(System.lineSeparator())
                .append("Jorge").append(" ")
                .append("100.0").append(" ")
                .append("USD")
                .append(System.lineSeparator());
        assertEquals(expected.toString(), engine.generate(em -> true));
    }

}