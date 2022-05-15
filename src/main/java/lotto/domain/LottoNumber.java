package lotto.domain;

import lotto.cons.ErrorMessageConst;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private int number;

    public static final int LOTTO_NUMBER_MIN_VALUE = 1;
    public static final int LOTTO_NUMBER_MAX_VALUE = 45;

    public LottoNumber(int number) {
        if(number < LOTTO_NUMBER_MIN_VALUE || number > LOTTO_NUMBER_MAX_VALUE){
            throw new IllegalArgumentException(
                    String.format(ErrorMessageConst.ERROR_INVALID_LOTTO_NUMBER_RANGE,
                            LOTTO_NUMBER_MIN_VALUE, LOTTO_NUMBER_MAX_VALUE));
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNumber());
    }

    @Override
    public boolean equals(Object o) {
        return ((LottoNumber)o).getNumber() == number;
    }
}
