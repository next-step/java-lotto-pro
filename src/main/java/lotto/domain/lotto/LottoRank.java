package lotto.domain.lotto;

import lotto.domain.winning.WinningStrategy;

import java.util.Arrays;

public enum LottoRank {

    LOSE(0, 0, (winningCount, isMatchBonus) -> winningCount < 3),
    FIFTH(3, 5_000, (winningCount, isMatchBonus) -> winningCount == 3),
    FOURTH(4, 50_000, (winningCount, isMatchBonus) -> winningCount == 4),
    THIRD(5, 1_500_000, (winningCount, isMatchBonus) -> winningCount == 5 && !isMatchBonus),
    SECOND(5, 30_000_000, (winningCount, isMatchBonus) -> winningCount == 5 && isMatchBonus),
    FIRST(6, 2_000_000_000, (winningCount, isMatchBonus) -> winningCount == 6);

    private final int matchCount;
    private final int prizeMoney;
    private final WinningStrategy<Integer, Boolean> winningStrategy;

    LottoRank(int matchCount, int prizeMoney, WinningStrategy<Integer, Boolean> winningStrategy) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.winningStrategy = winningStrategy;
    }

    public static LottoRank findBy(int winningCount, boolean isMatchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.winningStrategy.matching(winningCount, isMatchBonus))
                .findFirst()
                .orElse(LottoRank.LOSE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
