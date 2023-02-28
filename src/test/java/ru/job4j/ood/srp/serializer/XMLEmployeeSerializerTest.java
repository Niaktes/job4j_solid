package ru.job4j.ood.srp.serializer;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.model.Employee;

import javax.xml.bind.JAXBException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XMLEmployeeSerializerTest {

    @Test
    void whenSerializeTwoEmployeesThenGetSerializedEmployeesAsXMLText() throws JAXBException {
        Calendar calendar = new GregorianCalendar(2023, Calendar.FEBRUARY, 27, 0, 0);
        Employee first = new Employee("Gena", calendar, calendar, 100, Currency.USD);
        Employee second = new Employee("Lena", calendar, calendar, 100, Currency.RUB);
        List<Employee> employees = List.of(first, second);
        Serializer<Employee> serializer = new XMLEmployeeSerializer();
        StringBuilder expected = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>") .append("\n")
                .append("<employees>").append("\n")
                .append("    <employee name=\"Gena\">").append("\n")
                .append("        <hired>2023-02-27T00:00:00+03:00</hired>").append("\n")
                .append("        <fired>2023-02-27T00:00:00+03:00</fired>").append("\n")
                .append("        <currency>USD</currency>").append("\n")
                .append("        <salary>100.0</salary>").append("\n")
                .append("    </employee>").append("\n")
                .append("    <employee name=\"Lena\">").append("\n")
                .append("        <hired>2023-02-27T00:00:00+03:00</hired>").append("\n")
                .append("        <fired>2023-02-27T00:00:00+03:00</fired>").append("\n")
                .append("        <currency>RUB</currency>").append("\n")
                .append("        <salary>100.0</salary>").append("\n")
                .append("    </employee>").append("\n")
                .append("</employees>").append("\n");
        assertEquals(expected.toString(), serializer.serialize(employees));
    }

}