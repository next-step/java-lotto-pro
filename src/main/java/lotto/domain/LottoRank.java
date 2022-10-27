package lotto.domain;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    FAIL(0, 0);

    private final int matchCount;
    private final int winningPrice;

    LottoRank(int matchCount, int winningPrice) {
        this.matchCount = matchCount;
        this.winningPrice = winningPrice;
    }

    public static LottoRank getRank(int matchCount) {
        return Arrays.stream(LottoRank.values())
                .filter(v -> v.matchCount == matchCount)
                .findFirst()
                .orElse(LottoRank.FAIL);
    }

    public int getWinningPrice() {
        return this.winningPrice;
    }
}
