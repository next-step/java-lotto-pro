package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinningRank {
    SIX(6, 2000000000), 
    FIVE(5, 1500000), 
    FOUR(4, 50000), 
    THREE(3, 5000), 
    ZERO(0, 0);

    private final int matchCount;
    private final int reward;

    WinningRank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static WinningRank result(int matchCount) {
        return Arrays.stream(values()).filter(winningRank -> winningRank.matchCount == matchCount).findFirst().orElse(ZERO);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return this.reward;
    }
    
    public static List<WinningRank> createWinningRanks() {
        return Stream.of(SIX, FIVE, FOUR, THREE)
                .sorted(Comparator.comparing(WinningRank::getMatchCount))
                .collect(Collectors.toList());
    }

}
