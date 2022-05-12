package camp.nextstep.edu.step2;

import java.util.Objects;

public class WholeNumber {
    private final int number;

    public WholeNumber(final String input) {
        this.number = wholeIntegerBy(input);
    }

    private int wholeIntegerBy(final String input) {
        final int value = Integer.parseInt(input);
        if (0 > value) {
            throw new IllegalArgumentException("negative input is "+input);
        }
        return value;
    }

    public WholeNumber add(final WholeNumber wholeNumber) {
        return wholeNumber.add(this.number);
    }

    private WholeNumber add(int number) {
        if (Objects.equals(number, 0)) {
            return this;
        }
        return new WholeNumber(String.valueOf(this.number + number));
    }

    int value() {
        return this.number;
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
}
