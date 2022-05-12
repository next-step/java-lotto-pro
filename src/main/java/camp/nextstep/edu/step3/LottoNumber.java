package camp.nextstep.edu.step3;

import java.util.Objects;

public class LottoNumber {
    private final int number;

    public LottoNumber(final int number) {
        validation(number);
        this.number = number;
    }

    private void validation(final int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(String.format("invalid input : %d", number));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
