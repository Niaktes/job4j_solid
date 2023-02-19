package ru.job4j.ood.srp.report;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;

class ADReportEngineTest {

    @Test
    void whenADReportGeneratedThenTextWithConvertedSalary() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee first = new Employee("Jim", now, now, 100, Currency.USD);
        Employee second = new Employee("Beam", now, now, 100, Currency.RUB);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        String dateTime = parser.parse(now);
        store.add(first);
        store.add(second);
        Report engine = new ADReportEngine(store, parser, Currency.RUB);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary in RUB;")
                .append(System.lineSeparator())
                .append("Jim").append(" ")
                .append(dateTime).append(" ")
                .append(dateTime).append(" ")
                .append("7400.0")
                .append(System.lineSeparator())
                .append("Beam").append(" ")
                .append(dateTime).append(" ")
                .append(dateTime).append(" ")
                .append("100.0")
                .append(System.lineSeparator());
        assertEquals(expected.toString(), engine.generate(em -> true));
    }

}