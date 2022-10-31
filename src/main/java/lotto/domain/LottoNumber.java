package lotto.domain;

import lotto.constant.LottoMessage;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int lottoNumber;

    public LottoNumber(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(LottoMessage.ERROR_LOTTO_NUMBER_RANGE);
        }
        this.lottoNumber = num;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.lottoNumber - o.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getLottoNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof  LottoNumber)) {
            return false;
        }
        return ((LottoNumber)o).getLottoNumber() == lottoNumber;
    }
}
