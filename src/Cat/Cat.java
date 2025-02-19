package Cat;

import java.util.List;

/**
 * Класс, представляющий кота, который может мяукать.
 */
public class Cat implements Meower {
    private final String name;
    private int meowsCount = 0;

    /**
     * Создает кота с указанным именем.
     *
     * @param name Имя кота.
     */
    public Cat(String name) {
        this.name = name;
    }

    /**
     * Кот мяукает.
     */
    @Override
    public void meow() {
        System.out.println(name + ": мяу!");
        meowsCount++;
    }

    /**
     * Возвращает строковое представление кота.
     *
     * @return Строковое представление кота.
     */
    @Override
    public String toString() {
        return "Кот: " + name;
    }

    /**
     * Возвращает количество мяуканий кота.
     *
     * @return Количество мяуканий.
     */
    public int getMeowsCount() {
        return meowsCount;
    }

    /**
     * Заставляет всех мяукающих существ в списке мяукнуть.
     *
     * @param meowables Список мяукающих существ.
     */
    public static void makeAllMeowersMeow(List<? extends Meower> meowables) {
        for (Meower meower : meowables) {
            meower.meow();
        }
    }

    /**
     * Возвращает имя кота.
     *
     * @return Имя кота.
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает количество мяуканий кота.
     *
     * @param meowsCount Количество мяуканий.
     */
    public void setMeowsCount(int meowsCount) {
        this.meowsCount = meowsCount;
    }
}