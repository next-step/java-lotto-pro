package step3;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        this.number = number;
        validate();
    }

    private void validate() {
        if (isInvalidRange()) {
            throw new IllegalArgumentException("1~45의 숫자만 입력해주세요.");
        }
    }

    private boolean isInvalidRange() {
        return number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LottoNumber that = (LottoNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }
}
