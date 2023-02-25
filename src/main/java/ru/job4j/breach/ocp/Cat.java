package ru.job4j.breach.ocp;

import java.util.Random;

public class Cat {

    public void talk() {
        String[] phrases = {"Meow!", "Purr!", "Hiss!"};
        Random random = new Random();
        System.out.println(phrases[random.nextInt(0, phrases.length)]);
    }

}
