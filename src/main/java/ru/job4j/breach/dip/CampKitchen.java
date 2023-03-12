package ru.job4j.breach.dip;

public class CampKitchen {

    private CampFire camprire = new CampFire();

}

class CampFire {

    private int wood = 5;

    public Meat fry(Meat meat) throws InterruptedException {
        Thread.sleep(300_000);
        meat.setCooked(true);
        return meat;
    }

}

class Meat {

    private boolean isCooked = false;

    public boolean isCooked() {
        return isCooked;
    }

    public void setCooked(boolean cooked) {
        isCooked = cooked;
    }

}

/*
В данном случае нарушение принципа в поле класса CampKitchen - жесткая привязка к классу CampFire. Следовало бы создать интерфейс fireSource, который могли бы реализовать и CampFire, и GasBurner, и WoodStove.
И тип источника огня надо бы получать извне - при создании CampKitchen именно по интерфейсу принимать в конструктор переменную и присваивать её полю класса.
То же самое следовало бы сделать с топливом для костра. Почему он привязан только к дереву, которое почему-то у нас просто исчисляется определённым числом, которое будет участвовать в некоторой логике горения.
Однако, следовало бы просто взять абстрактный fuel, который внутри себя будет иметь разный "КПД горения", и исходя из этого высчитывать уже сколько будет гореть костер на этом топливе.
Нарушение принципа так же в принимаемом и возвращаемом параметре метода .fry() - он принимает только мясо, хотя поджарить на огне можно и рыбу, и птицу, и хлеб. Таким же образом и вернуть в методе нужно нечто абстрактное, вроде Food
*/