package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int lottoNumber;

    public LottoNumber(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] LottoNumber는 1 이상 45 이하여야 합니다.");
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
