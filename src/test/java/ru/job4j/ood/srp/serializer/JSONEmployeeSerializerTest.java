package ru.job4j.ood.srp.serializer;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.model.Employee;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JSONEmployeeSerializerTest {

    @Test
    void whenSerializeTwoEmployeesThenGetSerializedEmployeesAsJSONText() {
        Calendar calendar = new GregorianCalendar(2023, Calendar.FEBRUARY, 27, 0, 0);
        Employee first = new Employee("Gena", calendar, calendar, 100, Currency.USD);
        Employee second = new Employee("Lena", calendar, calendar, 100, Currency.RUB);
        List<Employee> employees = List.of(first, second);
        Serializer<Employee> serializer = new JSONEmployeeSerializer();
        StringBuilder expected = new StringBuilder()
                .append("{\"name\":\"Gena\",")
                .append("\"hired\":{\"year\":2023,\"month\":1,\"dayOfMonth\":27,\"hourOfDay\":0,\"minute\":0,\"second\":0},")
                .append("\"fired\":{\"year\":2023,\"month\":1,\"dayOfMonth\":27,\"hourOfDay\":0,\"minute\":0,\"second\":0},")
                .append("\"salary\":100.0,")
                .append("\"currency\":\"USD\"}").append(System.lineSeparator())
                .append("{\"name\":\"Lena\",")
                .append("\"hired\":{\"year\":2023,\"month\":1,\"dayOfMonth\":27,\"hourOfDay\":0,\"minute\":0,\"second\":0},")
                .append("\"fired\":{\"year\":2023,\"month\":1,\"dayOfMonth\":27,\"hourOfDay\":0,\"minute\":0,\"second\":0},")
                .append("\"salary\":100.0,")
                .append("\"currency\":\"RUB\"}").append(System.lineSeparator());
        assertEquals(expected.toString(), serializer.serialize(employees));
    }

}