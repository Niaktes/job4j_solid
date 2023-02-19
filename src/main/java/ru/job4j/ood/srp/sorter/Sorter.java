package ru.job4j.ood.srp.sorter;

import ru.job4j.ood.srp.model.Employee;

import java.util.List;

public interface Sorter {

    List<Employee> sortAscending(List<Employee> employees);

    List<Employee> sortDescending(List<Employee> employees);

}