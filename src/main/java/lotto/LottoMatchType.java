package lotto;

import java.util.Arrays;

public enum LottoMatchType {
    OTHER(0, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int matchCount;
    private final int winningAmount;

    LottoMatchType(int matchCount, int winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public static LottoMatchType valueOf(int matchCount) {
        return Arrays.stream(LottoMatchType.values())
            .filter(lottoMatchType -> lottoMatchType.match(matchCount))
            .findFirst()
            .orElse(OTHER);
    }

    private boolean match(int matchCount) {
        return this.matchCount == matchCount;
    }

    public boolean dontPrint() {
        return this == OTHER;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningAmount() {
        return this.winningAmount;
    }

    public int multiply(Integer count) {
        return this.winningAmount * count;
    }
}
