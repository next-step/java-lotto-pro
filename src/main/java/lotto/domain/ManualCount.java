package lotto.domain;

import lotto.exception.LottoException;
import lotto.exception.LottoExceptionType;

public class ManualCount {
    private static final int MIN = 0;
    private final int value;

    private ManualCount(final int manualCount) {
        this.value = manualCount;
    }

    public static ManualCount of(final int lottoCount, final int manualCount) {
        validate(lottoCount, manualCount);
        return new ManualCount(manualCount);
    }

    private static void validate(int lottoCount, int manualCount) {
        invalidMinus(manualCount);
        invalidCount(lottoCount, manualCount);
    }

    private static void invalidMinus(int manualCount) {
        if (manualCount < MIN) {
            throw new LottoException(LottoExceptionType.MANUAL_COUNT_MINUS_INVALID);
        }
    }

    private static void invalidCount(int lottoCount, int manualCount) {
        if (manualCount > lottoCount) {
            throw new LottoException(LottoExceptionType.MANUAL_COUNT_INVALID);
        }
    }

    public int getValue() {
        return value;
    }
}
