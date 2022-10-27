package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Numbers {

    private final List<Number> numberList;

    public Numbers() {
        this(new ArrayList<>());
    }

    public Numbers(List<Number> numberList) {
        this.numberList = numberList;
    }

    public void add(Number number) {
        this.numberList.add(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers = (Numbers) o;
        return Objects.equals(numberList, numbers.numberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberList);
    }

    public Number sum() {
        Number sum = Number.valueOf("0");
        for (Number number : numberList) {
            sum = sum.plus(number);
        }
        return sum;
    }
}
