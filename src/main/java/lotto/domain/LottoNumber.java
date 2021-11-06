package lotto.domain;

import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static final String LOTTO_NUMBER_RANGE_ERROR = String.format(
            "로또 번호는 %d~%d 범위의 숫자만 가능합니다.", MIN_NUMBER, MAX_NUMBER);

    public final int number;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public static List<Integer> getValues() {
        List<Integer> values = new ArrayList<>();
        for (int value = MIN_NUMBER; value < MAX_NUMBER; value++) {
            values.add(value);
        }
        Collections.shuffle(values);
        return values;
    }

    private void validateNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new LottoException(LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    public int getNumber() {
        return number;
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

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(number, o.getNumber());
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
