package ru.job4j.ood.srp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Employees {

    private List<Employee> employeesList;

    public Employees() { }

    public Employees(List<Employee> employees) {
        this.employeesList = employees;
    }

    @XmlElement(name = "employee")
    public List<Employee> getEmployees() {
        return employeesList;
    }

    public void setEmployees(List<Employee> employees) {
        this.employeesList = employees;
    }
}
