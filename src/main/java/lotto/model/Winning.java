package lotto.model;

import java.util.Arrays;

public enum Winning {
    FIRST_PRIZE(6, new Money(2_000_000_000)),
    SECOND_PRIZE(5, new Money(1_500_000)),
    THIRD_PRIZE(4, new Money(50_000)),
    FOURTH_PRIZE(3, new Money(5_000)),
    NONE(0, new Money(0)),
    ;

    private final int matchCount;
    private final Money reward;

    Winning(int matchCount, Money reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Winning ofMatchCount(int count) {
        return Arrays.stream(Winning.values())
                .filter(w -> w.matchCount == count)
                .findFirst()
                .orElse(NONE);
    }

    public Money getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
