package camp.nextstep.edu.step2;

import java.util.Objects;

public class WholeNumber {
    private final int number;

    public WholeNumber(final int number) {
        this.number = number;
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
