package ru.job4j.template;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
class GeneratorSimpleTest {

    Generator generator;
    String template = "Here is ${name} string for ${purpose}";
    String expected = "Here is Sergo's string for don't know";

    @BeforeEach
    void init() {
        generator = new GeneratorSimple();
    }

    @Test
    void whenArgumentsMatchTemplateThenGetString() {
        Map<String, String> arguments = Map.of("name", "Sergo's", "purpose", "don't know");
        assertEquals(expected, generator.produce(template, arguments));
    }

    @Test
    void whenWrongArgumentsThenGetException() {
        Map<String, String> arguments = Map.of("surname", "Bluher", "purpose", "don't know");
        assertThrows(IllegalArgumentException.class, () -> generator.produce(template, arguments));
    }

    @Test
    void whenInsufficientArgumentsThenGetException() {
        Map<String, String> arguments = Map.of("purpose", "don't know");
        assertThrows(IllegalArgumentException.class, () -> generator.produce(template, arguments));
    }

    @Test
    void whenExtraArgumentsThenGetException() {
        Map<String, String> arguments = Map.of("name", "Sergo's", "purpose", "don't know", "some", "something");
        assertThrows(IllegalArgumentException.class, () -> generator.produce(template, arguments));
    }

}