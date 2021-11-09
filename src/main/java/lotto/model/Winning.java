package lotto.model;

import java.util.Arrays;

public enum Winning {
    FIRST_PRIZE(6, new Money(2_000_000_000), false),
    SECOND_PRIZE(5, new Money(3_000_000), true),
    THIRD_PRIZE(5, new Money(1_500_000), false),
    FOURTH_PRIZE(4, new Money(50_000), false),
    FIFTH_PRIZE(3, new Money(5_000), false),
    NONE(0, new Money(0), false),
    ;

    private final int matchCount;
    private final Money reward;
    private final boolean bonus;

    Winning(int matchCount, Money reward, boolean bonus) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.bonus = bonus;
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

    public boolean needBonus() {
        return bonus;
    }
}
