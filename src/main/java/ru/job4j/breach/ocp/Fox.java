package ru.job4j.breach.ocp;

import java.util.Random;

public class Fox {

    public void talk() {
        String[] phrases = {"Ring-ding-ding-ding-dingeringeding!", "Hatee-hatee-hatee-ho!", "Joff-tchoff-tchoffo-tchoffo-tchoff!"};
        Random random = new Random();
        System.out.println(phrases[random.nextInt(0, phrases.length)]);
    }

}
/*
В данном случае отсутствует интерфейс для реализации разных типов животных, а следовательно при создании новых типов животных придётся переписывать методы,
в которых происходит создание объектов и вызов метода talk() - нет зависимости от абстракций;
Random создается в теле метода, хотя логичнее было бы передавать его в конструктор класса, потому что метод выбора фразы может поменяться;
Список фраз задан непосредственно в методе, хотя логичнее было бы вынести его в поле класса.
*/
