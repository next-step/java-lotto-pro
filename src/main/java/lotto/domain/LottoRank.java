package lotto.domain;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    FAIL(0, 0);

    private static final int SECOND_OR_THIRD = 5;
    private final int matchCount;
    private final int winningPrice;

    LottoRank(int matchCount, int winningPrice) {
        this.matchCount = matchCount;
        this.winningPrice = winningPrice;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == SECOND_OR_THIRD) {
            return decideSecondOrThird(matchBonus);
        }

        return Arrays.stream(LottoRank.values())
                .filter(v -> v.matchCount == matchCount)
                .findFirst()
                .orElse(LottoRank.FAIL);
    }

    private static LottoRank decideSecondOrThird(boolean matchBonus) {
        return matchBonus ? SECOND : THIRD;
    }

    public int getWinningPrice() {
        return this.winningPrice;
    }

    public int getMatchCount() {
        return this.matchCount;
    }
}
