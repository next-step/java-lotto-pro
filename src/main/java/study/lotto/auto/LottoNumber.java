package study.lotto.auto;

import java.util.Objects;

import static study.lotto.auto.MessageUtil.INVALID_LOTTO_NUMBER_ERR_MSG;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int MIN_LOTTO_NUMBER = 1;
    private final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        this.number = number;
        validateNumber();
    }

    private void validateNumber() {
        if(number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalStateException(INVALID_LOTTO_NUMBER_ERR_MSG);
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }

    public int getNumber() {
        return this.number;
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
        return getNumber() == that.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
