package lotto.domain;

import java.util.Objects;

public class Number implements Comparable<Number> {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int number;

    public Number(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int randomNumber) {
        if (randomNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 최대 크기 : " + MAX_NUMBER);
        }
        if (randomNumber < MIN_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 최소 크기 : " + MIN_NUMBER);
        }
    }

    @Override
    public int compareTo(Number o) {
        if (this.number > o.number) {
            return 1;
        }
        if (this.number < o.number) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

}
