package fraction;

import java.util.Objects;

/**
 * Класс, представляющий дробь.
 */
public class Fraction implements IFraction {
    private int numerator;
    private int denominator;
    private Double cachedValue = null;

    /**
     * Создает дробь с числителем 0 и знаменателем 1.
     */
    public Fraction() {
        this(0, 1);
    }

    /**
     * Создает дробь с указанными числителем и знаменателем.
     *
     * @param numerator   Числитель.
     * @param denominator Знаменатель.
     * @throws IllegalArgumentException Если знаменатель равен нулю.
     */
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }

        int gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;

        if (this.denominator < 0) {
            this.numerator *= -1;
            this.denominator *= -1;
        }
    }

    /**
     * Возвращает значение дроби.
     *
     * @return Значение дроби.
     */
    @Override
    public double getValue() {
        if (cachedValue == null) {
            cachedValue = (double) numerator / denominator;
        }
        return cachedValue;
    }

    /**
     * Устанавливает числитель дроби.
     *
     * @param numerator Новый числитель.
     */
    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        cachedValue = null;
    }

    /**
     * Устанавливает знаменатель дроби.
     *
     * @param denominator Новый знаменатель.
     * @throws IllegalArgumentException Если знаменатель равен нулю.
     */
    @Override
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        this.denominator = denominator;
        cachedValue = null;
    }

    /**
     * Возвращает строковое представление дроби.
     *
     * @return Строковое представление дроби.
     */
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    /**
     * Вычисляет наибольший общий делитель двух чисел.
     *
     * @param a Первое число.
     * @param b Второе число.
     * @return Наибольший общий делитель.
     */
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    /**
     * Сравнивает две дроби на равенство.
     *
     * @param o Объект для сравнения.
     * @return true, если дроби равны, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fraction)) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    /**
     * Возвращает хэш-код дроби.
     *
     * @return Хэш-код дроби.
     */
    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}