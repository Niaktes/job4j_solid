package ru.job4j.ood.srp.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.model.Employee;

import java.util.List;

public class JSONEmployeeSerializer implements Serializer<Employee> {

    private final Gson gson;

    public JSONEmployeeSerializer() {
        this.gson = new GsonBuilder().create();
    }

    @Override
    public String serialize(List<Employee> employees) {
         return gson.toJson(employees);
    }

}