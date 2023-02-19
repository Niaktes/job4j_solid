package ru.job4j.ood.srp.report;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;

class ITReportEngineTest {

    @Test
    void whenITReportGeneratedThenGetCSVFormattedStrings() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee first = new Employee("Biba", now, now, 100, Currency.RUB);
        Employee second = new Employee("Boba", now, now, 100, Currency.RUB);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        String dateTime = parser.parse(now);
        store.add(first);
        store.add(second);
        Report engine = new ITReportEngine(store, parser, ",");
        StringBuilder expected = new StringBuilder()
                .append("Name,Hired,Fired,Salary,Currency").append(System.lineSeparator())
                .append("Biba,").append(dateTime).append(",").append(dateTime).append(",100.0,RUB").append(System.lineSeparator())
                .append("Boba,").append(dateTime).append(",").append(dateTime).append(",100.0,RUB").append(System.lineSeparator());
        assertEquals(expected.toString(), engine.generate(em -> true));
    }

}