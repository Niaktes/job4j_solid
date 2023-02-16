package ru.job4j.ood.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.List;

@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
class Cinema3DTest {

    @Test
    void whenBuyThenGetTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertEquals(ticket, new Ticket3D());
    }

    @Test
    void whenAddSessionThenItExistsBetweenAllSessions() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        List<Session> sessions = cinema.find(ses -> true);
        assertTrue(sessions.contains(session));
    }

    @Test
    void whenNoSuchSessionThenEmptyList() {
        Cinema cinema = new Cinema3D();
        List<Session> sessions = cinema.find(ses -> false);
        assertNotNull(sessions);
        assertTrue(sessions.isEmpty());
    }

    @Test
    void whenBuyOnInvalidRowThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        assertThrows(IllegalArgumentException.class, () -> cinema.buy(account, -1, 1, date));
    }

    @Test
    void whenBuyOnInvalidColumnThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        assertThrows(IllegalArgumentException.class, () -> cinema.buy(account, 1, -1, date));
    }

    @Test
    void whenBuyOnInvalidAccountThenGetException() {
        Account account = null;
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        assertThrows(IllegalArgumentException.class, () -> cinema.buy(account, 1, 1, date));
    }

    @Test
    void whenPlaceOccupiedThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        assertDoesNotThrow(() -> cinema.buy(account, 1, 1, date));
        assertThrows(IllegalArgumentException.class, () -> cinema.buy(account, 1, 1, date));
    }

    @Test
    void whenAddExistedSessionThenGetException() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        assertThrows(IllegalArgumentException.class, () -> cinema.add(session));
    }

}