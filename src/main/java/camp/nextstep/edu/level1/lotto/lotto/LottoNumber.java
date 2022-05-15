package camp.nextstep.edu.level1.lotto.lotto;

import camp.nextstep.edu.common.PositiveNumber;

import java.util.Objects;

public class LottoNumber {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    private final PositiveNumber number;

    public LottoNumber(PositiveNumber number) {
        checkValidLottoNumber(number);
        this.number = number;
    }

    public LottoNumber(long number) {
        this(new PositiveNumber(number));
    }

    private void checkValidLottoNumber(PositiveNumber number) {
        if (number.getValue() < LOTTO_START_NUMBER || number.getValue() > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 만 허용됩니다.");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
