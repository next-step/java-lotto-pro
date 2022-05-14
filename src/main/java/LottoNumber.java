import java.util.Objects;

public class LottoNumber {
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;

    private final int number;

    public LottoNumber(int number) {
        check(number);
        this.number = number;
    }

    private void check(int number) {
        if (number < LOWER_BOUND || number > UPPER_BOUND)
            throw new RuntimeException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LottoNumber))
            return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
