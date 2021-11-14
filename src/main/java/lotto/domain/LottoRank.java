package lotto.domain;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prizeMoney;

    LottoRank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank of(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.isEqualTo(matchCount))
                .map(lottoRank -> lottoRank.matchSecondLank(matchCount, matchBonus))
                .findFirst()
                .orElse(NONE);
    }

    private LottoRank matchSecondLank(int matchCount, boolean matchBonus) {
        if (!matchBonus && matchCount == SECOND.matchCount) {
            return THIRD;
        }
        return this;
    }

    public boolean isNotNone() {
        return this != NONE;
    }

    private boolean isEqualTo(int matchCount) {
        return this.matchCount == matchCount;
    }

    public long calculatePrize(long lottoLankCount) {
        return getPrizeMoney() * lottoLankCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

}
