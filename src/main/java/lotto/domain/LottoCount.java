package lotto.domain;

import java.util.Objects;

import lotto.exception.LottoErrorCode;
import lotto.exception.LottoException;
import view.Printable;

public class LottoCount implements Printable {
    private static final int MIN_COUNT = 0;
    private final long count;

    public LottoCount(long count) {
        validate(count);
        this.count = count;
    }

    private void validate(long count) {
        if (count < MIN_COUNT) {
            throw new LottoException(LottoErrorCode.INVALID_LOTTO_COUNT);
        }
    }

    public boolean isBiggerThan(long count) {
        return count < this.count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoCount)) {
            return false;
        }
        LottoCount that = (LottoCount)o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public String makePrintableMessage() {
        return String.valueOf(count);
    }
}
