package lotto.domain;

import java.util.Objects;

public class Number implements Comparable<Number> {

    private int number;

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(Number o) {
        if (this.number > o.getNumber()) {
            return 1;
        }
        if (this.number < o.getNumber()) {
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

}
