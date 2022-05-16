package lotto.domain;

import java.util.Arrays;

public enum LottoStatistic {
    SIX_WINNING_AMOUNT(6, 2_000_000_000),
    FIVE_WINNING_AMOUNT(5, 1_500_000),
    FOUR_WINNING_AMOUNT(4, 50_000),
    THREE_WINNING_AMOUNT(3, 5_000),
    NOTHING(0, 0);

    private int matchCount;
    private int winningAmount;

    LottoStatistic(int matchCount, int winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getWinningAmount() {
        return this.winningAmount;
    }

    public static LottoStatistic valueOf(int matchCount) {
        return Arrays.stream(values())
                .filter(lottoStatistic -> lottoStatistic.matchCount == matchCount)
                .findFirst()
                .orElse(LottoStatistic.NOTHING);
    }
}
