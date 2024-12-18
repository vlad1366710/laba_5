package Cat;

import java.util.List;

public class Cat implements Meower {
    private final String name;
    private int meowsCount = 0;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void meow() {
        System.out.println(name + ": мяу!");
        meowsCount++;
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }

    public int getMeowsCount() {
        return meowsCount;
    }

    public static void makeAllMeowersMeow(List<? extends Meower> meowables) {
        for (Meower meower : meowables) {
            meower.meow();
        }
    }

    public String getName() {
        return name;
    }

    public void setMeowsCount(int meowsCount) {
        this.meowsCount = meowsCount;
    }
}