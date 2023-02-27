package ru.job4j.ood.srp.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class JSONSerializer<T> implements Serializer<T> {

    private final Gson gson;

    public JSONSerializer() {
        this.gson = new GsonBuilder().create();
    }

    @Override
    public String serialize(List<T> elements) {
        StringBuilder json = new StringBuilder();
        for (T element : elements) {
            json.append(gson.toJson(element))
                    .append(System.lineSeparator());
        }
        return json.toString();
    }
}