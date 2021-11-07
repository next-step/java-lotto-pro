package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinningRank {
    FIRST_RANK(6, 2_000_000_000), 
    SECOND_RANK(5, 30_000_000), 
    THIRD_RANK(5, 1_500_000), 
    FOURTH_RANK(4, 50_000), 
    FIFTH_RANK(3, 5_000), 
    FAIL(0, 0);

    private final int matchCount;
    private final int reward;

    WinningRank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static WinningRank resultRank(int matchCount, boolean isMatchBonus) {
        return Arrays.stream(values())
                .filter(winningRank -> winningRank.judgeRank(matchCount, isMatchBonus))
                .findFirst()
                .orElse(FAIL);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return this.reward;
    }
    
    public static List<WinningRank> createWinningRanks() {
        return Stream.of(FIRST_RANK, SECOND_RANK, THIRD_RANK, FOURTH_RANK, FIFTH_RANK)
                .sorted(Comparator.comparing(WinningRank::getReward))
                .collect(Collectors.toList());
    }
    
    private boolean judgeRank(int count, boolean isMatchBonus) {
        if (this.matchCount == SECOND_RANK.matchCount && this.reward == SECOND_RANK.reward) {
            return this.matchCount == count && isMatchBonus;
        }
        return this.matchCount == count;
    }
}
