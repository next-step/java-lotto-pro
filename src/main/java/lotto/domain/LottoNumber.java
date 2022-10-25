package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int value;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    public LottoNumber(final int number) {
        validate(number);
        this.value = number;
    }

    private void validate(final int number) {
        if(number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(String.format("%d는 1~45 범위에 벗어난 숫자입니다.", number));
        }
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public int compareTo(final LottoNumber lottoNumber) {
        return Integer.compare(lottoNumber.getValue(), this.getValue());
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        final LottoNumber that = (LottoNumber) o;
        return this.value == that.value;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + this.value;
        return result;
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "value=" + this.value +
                '}';
    }
}
