package lotto.model;


import lotto.util.GameRule;
import lotto.view.GameMessage;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        lottoNumberRangeCheck(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    private void lottoNumberRangeCheck(int number) {
        if (number < GameRule.LOTTO_START_NUMBER || number > GameRule.LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(GameMessage.invalidInputMsg(GameMessage.ERROR_WINNING_NUMBER_INPUT));
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(getLottoNumber(), o.getLottoNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
