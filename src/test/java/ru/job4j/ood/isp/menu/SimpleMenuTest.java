package ru.job4j.ood.isp.menu;

import ru.job4j.ood.isp.menu.Menu.MenuItemInfo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

class SimpleMenuTest {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    @Test
    void whenAddThenReturnSame() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        MenuItemInfo expected = new MenuItemInfo("Сходить в магазин", List.of("Купить продукты"), STUB_ACTION, "1.");
        assertEquals(expected, menu.select("Сходить в магазин").get());
        expected = new MenuItemInfo("Купить продукты", List.of("Купить хлеб", "Купить молоко"), STUB_ACTION, "1.1.");
        assertEquals(expected, menu.select("Купить продукты").get());
        expected = new MenuItemInfo("Покормить собаку", List.of(), STUB_ACTION, "2.");
        assertEquals(expected, menu.select("Покормить собаку").get());
        menu.forEach(i -> System.out.println(i.getNumber() + i.getName()));
    }

    @Test
    void whenSelectWrongElementThenExceptionThrown() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        Optional<MenuItemInfo> optional = menu.select("Купить хлеб");
        assertThrows(NoSuchElementException.class, optional::get);
    }

    @Test
    void whenAddExistsElementThenExceptionThrown() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        assertThrows(IllegalArgumentException.class, () -> menu.add(Menu.ROOT, "Купить продукты", STUB_ACTION));
    }

    @Test
    void whenSelectThenGetElementNumber() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        assertEquals("1.1.", menu.select("Купить продукты").get().getNumber());
        assertEquals("2.", menu.select("Покормить собаку").get().getNumber());
    }

    @Test
    void whenIterateThenGetElementsInCorrectOrder() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        Iterator<MenuItemInfo> iterator = menu.iterator();
        assertEquals("Сходить в магазин", iterator.next().getName());
        assertEquals("1.1.", iterator.next().getNumber());
        assertEquals("Купить хлеб", iterator.next().getName());
        assertEquals("1.1.2.", iterator.next().getNumber());
        assertEquals("Покормить собаку", iterator.next().getName());
    }

}