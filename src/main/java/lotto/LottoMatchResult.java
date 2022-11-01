package lotto;

import java.util.Arrays;

public enum LottoMatchResult {
    NOTHING(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    ALL(6);

    private final int count;

    public static LottoMatchResult fromCount(final int count) {
        return Arrays.stream(values())
            .filter(lottoMatchResult -> lottoMatchResult.count == count)
            .findFirst()
            .orElse(LottoMatchResult.NOTHING);
    }

    LottoMatchResult(final int count) {
        this.count = count;
    }
}
