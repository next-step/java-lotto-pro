package lotto.domain.lotto;

import java.util.Arrays;

public enum LottoRank {

    LOSE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    public static final int COMPARISON_MATCH_COUNT = 5;

    private final int matchCount;
    private final int prizeMoney;

    LottoRank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank findBy(int matchCount, boolean isMatchBonus) {
        LottoRank lottoRank = Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(LottoRank.LOSE);

        if (lottoRank.getMatchCount() == COMPARISON_MATCH_COUNT) {
            lottoRank = isMatchBonus ? LottoRank.SECOND : LottoRank.THIRD;
        }
        return lottoRank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
