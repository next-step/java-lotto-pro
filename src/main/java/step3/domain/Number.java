package step3.domain;


import java.util.Objects;

public class Number implements Comparable<Number> {

    private final int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Number)) {
            return false;
        }
        return hashCode() == ((Number) o).hashCode();
    }

    @Override
    public int compareTo(Number o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
