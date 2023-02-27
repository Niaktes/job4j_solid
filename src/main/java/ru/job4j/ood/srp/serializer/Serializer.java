package ru.job4j.ood.srp.serializer;

import java.util.List;

public interface Serializer<T> {

    String serialize(List<T> elements);

}