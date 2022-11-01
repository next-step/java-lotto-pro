package lotto;

import java.util.Arrays;

public enum LottoMatchType {
    OTHER(0, 0, ""),
    THREE(3, 5000, "3개 일치"),
    FOUR(4, 50000, "4개 일치"),
    FIVE(5, 1500000, "5개 일치"),
    FIVE_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치"),
    SIX(6, 2000000000, "6개 일치");

    private final int matchCount;
    private final int winningAmount;
    private final String presentString;

    LottoMatchType(int matchCount, int winningAmount, String presentString) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
        this.presentString = presentString;
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

    public boolean excludePrintAndMultiply() {
        return this == OTHER;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getWinningAmount() {
        return this.winningAmount;
    }

    public String getPresentString() {
        return this.presentString;
    }

    public int multiply(Integer count) {
        if (excludePrintAndMultiply()) {
            return 0;
        }
        return this.winningAmount * count;
    }

    public LottoMatchType promotionBonusBall(boolean matchBonusBall) {
        if (isFiveMatchCount() && matchBonusBall) {
            return FIVE_BONUS;
        }
        return this;
    }

    private boolean isFiveMatchCount() {
        return this == FIVE;
    }
}
