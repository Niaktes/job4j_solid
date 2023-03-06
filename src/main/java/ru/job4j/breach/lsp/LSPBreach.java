package ru.job4j.breach.lsp;

import java.time.LocalTime;

class Bowl {

    private float fullness;

    public Bowl() {
        this.fullness = 0;
    }

    public void fillBowl(int food) {
        if (this.fullness + food > 99) {
            throw new IllegalArgumentException("Food will be on the flor.");
        }
        this.fullness += food;
    }

    public float checkBowl() {
        return fullness;
    }

}

class Cat {

    boolean sleepy;
    int happiness = 50;

    public Cat(LocalTime time) {
        this.sleepy = !time.isAfter(LocalTime.NOON);
    }

    public void foodCheck(Bowl bowl) {
        if (bowl.checkBowl() > 80) {
            this.happiness = 100;
            makeSound("Purrr!");
        }
        if (bowl.checkBowl() < 10) {
            this.happiness = 20;
            makeSound("Meow!");
        }
    }

    public void makeSound(String sound) {
        if (!sleepy) {
            System.out.println(sound);
        }
    }

}

class MyCat extends Cat {

    public MyCat(LocalTime time) {
        super(time);
    }

    @Override
    public void foodCheck(Bowl bowl) {
        if (bowl.checkBowl() > 70) {
            this.happiness = 100;
            makeSound("Purrr!");
        }
        if (bowl.checkBowl() < 60) {
            this.happiness = 20;
            makeSound("Meow!");
        }
    }

    @Override
    public void makeSound(String sound) {
            System.out.println(sound);
    }

}

public class LSPBreach {

    public static void main(String[] args) {
        Bowl bowl = new Bowl();
        Cat cat = new MyCat(LocalTime.now());
        if (cat.getClass() == MyCat.class) {
            bowl.fillBowl(75);
        }
        cat.foodCheck(bowl);
    }

}

/*
В данном случае в методе foodCheck() класса MyCat сразу и понижается постусловие, повышается предусловие, а условие в методе makeSound() вообще куда-то потерялось,
и кошка будет издавать звуки даже если сонная, что нарушает принцип работы родительского класса.
Плюс мы проводим проверку класса cat.getClass() == MyCat.class в методе main(), чтобы понимать сколько корма сыпать, и это явно говорит нам о нарушении принципа LSP.
*/
