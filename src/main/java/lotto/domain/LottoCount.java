package lotto.domain;

import java.util.Objects;
import lotto.dto.LottoCountDTO;
import lotto.exception.LottoCountException;

public class LottoCount {

    private static final int DEFAULT_COUNT = 0;
    private final int lottoCount;

    public LottoCount(int lottoCount) {
        validateLottoCount(lottoCount);
        this.lottoCount = lottoCount;
    }

    private void validateLottoCount(int lottoCount) {
        if (lottoCount < DEFAULT_COUNT) {
            throw new LottoCountException();
        }
    }

    public LottoCountDTO toLottoCountDTO() {
        return new LottoCountDTO(lottoCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LottoCount that = (LottoCount) o;

        return lottoCount == that.lottoCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoCount);
    }
}
