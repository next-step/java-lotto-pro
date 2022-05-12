package camp.nextstep.edu.step2;

import java.util.Objects;

public class WholeNumber {
    private final int number;

    public WholeNumber(final String input) {
        this.number = wholeIntegerBy(input);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WholeNumber that = (WholeNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    private int wholeIntegerBy(final String input) {
        final int value = Integer.parseInt(input);
        if (0 > value) {
            throw new RuntimeException("input is negative value");
        }
        return value;
    }
}
