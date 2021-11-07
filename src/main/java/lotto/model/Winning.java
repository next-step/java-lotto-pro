package lotto.model;

import java.util.Arrays;

public enum Winning {
    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(5, 1_500_000),
    THIRD_PRIZE(4, 50_000),
    FOURTH_PRIZE(3, 5_000),
    NONE(0, 0),
    ;

    private final int matchCount;
    private final int reward;

    Winning(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Winning ofMatchCount(int count) {
        return Arrays.stream(Winning.values())
                .filter(w -> w.matchCount == count)
                .findFirst()
                .orElse(NONE);
    }

    public int getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
