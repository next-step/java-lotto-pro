package lotto;

import java.util.Objects;

import static lotto.util.RandomNumberUtils.NUMBER_RANGE_FROM;
import static lotto.util.RandomNumberUtils.NUMBER_RANGE_TO;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int number;

    public LottoNumber(int number) {
        validateLottoNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    private void validateLottoNumber(int number) {
        if (number < NUMBER_RANGE_FROM || number > NUMBER_RANGE_TO) {
            throw new IllegalArgumentException("Lotto number should be from 1 to 45.");
        }
    }

    @Override
    public int compareTo(LottoNumber that) {
        return Integer.compare(this.number, that.number);
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
