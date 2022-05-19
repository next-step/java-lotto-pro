import java.util.Objects;

public class LottoNumber {
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;

    private final int number;

    public LottoNumber(int number) {
        if (number < LOWER_BOUND || number > UPPER_BOUND) {
            throw new IllegalArgumentException("로또 번호 숫자의 범위는 " + LOWER_BOUND + "과 " + UPPER_BOUND + " 사이여야 합니다.");
        }

        this.number = number;
    }

    public LottoNumber(String number) {
        this(Integer.parseInt(number));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber)) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }
}
