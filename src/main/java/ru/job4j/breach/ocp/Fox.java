package ru.job4j.breach.ocp;

import java.util.Random;

public class Fox {

    public void talk() {
        String[] phrases = {"Ring-ding-ding-ding-dingeringeding!", "Hatee-hatee-hatee-ho!", "Joff-tchoff-tchoffo-tchoffo-tchoff!"};
        Random random = new Random();
        System.out.println(phrases[random.nextInt(0, phrases.length)]);
    }

}
