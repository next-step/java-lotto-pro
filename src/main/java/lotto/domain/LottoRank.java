package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    LOSE(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final int prize;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoRank findMatch(int matchCount) {
        return Arrays.stream(values())
            .filter(rank -> rank.matchCount == matchCount)
            .findFirst()
            .orElse(LOSE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
