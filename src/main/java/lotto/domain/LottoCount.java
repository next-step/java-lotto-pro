package lotto.domain;

import lotto.domain.error.LottoCountErrorCode;

import java.util.Objects;

public class LottoCount {

    private static final int MIN = 0;
    private final int lottoCount;

    public LottoCount(int lottoCount) {
        if (lottoCount < MIN) {
            throw new IllegalArgumentException(LottoCountErrorCode.NOT_ALLOW_SMALLER_THAN_ONE.getMessage());
        }
        this.lottoCount = lottoCount;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public boolean isZero() {
        return Objects.equals(lottoCount, MIN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoCount that = (LottoCount) o;

        return lottoCount == that.lottoCount;
    }

    @Override
    public int hashCode() {
        return lottoCount;
    }
}
