package lotto.model;

public class LottoNumber {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final String ERROR_OUT_OF_RANGE_MESSAGE = "로또 숫자는 1~45 사이의 숫자여야 합니다.";

    private final int number;

    public LottoNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE_MESSAGE);
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumber lottoNumber1 = (LottoNumber) o;

        return number == lottoNumber1.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
