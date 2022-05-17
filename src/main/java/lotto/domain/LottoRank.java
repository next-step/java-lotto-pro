package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private int matchCount;
    private int prizeMoney;

    LottoRank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public static LottoRank rank(int inputMatchCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == inputMatchCount)
                .findFirst()
                .orElse(LottoRank.MISS);
    }

    public static boolean isWinning(LottoRank lottoRank) {
        return lottoRank != LottoRank.MISS;
    }

    public static List<LottoRank> winningRanks() {
        return Arrays.asList(LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST);
    }
}
