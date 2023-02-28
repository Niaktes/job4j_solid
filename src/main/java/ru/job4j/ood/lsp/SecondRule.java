package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.time.Month;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

class WorkDays implements  Iterable<Integer> {

    /* нарушение: постусловие ослаблено в подклассе */

    private final Map<LocalDate, Integer> workDays = new LinkedHashMap<>();

    public void add(LocalDate date, int hours) {
        workDays.put(date, hours);
    }

    @Override
    public Iterator<Integer> iterator() {
        return workDays.values().iterator();
    }

}

class CountingRoom {

    protected int normHours;
    protected int payPerHour;

    public CountingRoom(int normHours, int payPerHour) {
        this.normHours = normHours;
        this.payPerHour = payPerHour;
    }

    public int pay(WorkDays workDays) {
        int factHours = 0;
        for (Integer hoursPerDay : workDays) {
            factHours += hoursPerDay;
        }
        if (factHours < normHours) {  /* <= постусловие */
            throw new IllegalArgumentException("Worker didn't work enough!");
        }
        return factHours * payPerHour;
    }

}

class ShopCountingRoom extends CountingRoom {

    public ShopCountingRoom(int normHours, int payPerHour) {
        super(normHours, payPerHour);
    }

    @Override
    public int pay(WorkDays workDays) {
        int factHours = 0;
        for (Integer hoursPerDay : workDays) {
            factHours += hoursPerDay;
        }
        return factHours * payPerHour; /* постусловие отсутствует (ослаблено) */
    }

}

public class SecondRule {

    public static void main(String[] args) {
        WorkDays workDays = new WorkDays();
        workDays.add(LocalDate.of(2023, Month.FEBRUARY, 1), 8);
        workDays.add(LocalDate.of(2023, Month.FEBRUARY, 2), 7);
        workDays.add(LocalDate.of(2023, Month.FEBRUARY, 3), 6);

        CountingRoom countingRoom = new ShopCountingRoom(3 * 8, 500);
        System.out.println(countingRoom.pay(workDays));
    }
}
