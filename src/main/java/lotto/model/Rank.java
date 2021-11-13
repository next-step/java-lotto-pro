package lotto.model;

import java.util.Arrays;

public enum Rank {
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

    Rank(int matchCount, Money reward, boolean bonus) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.bonus = bonus;
    }

    public static Rank of(int count, boolean bonus) {
        return Arrays.stream(Rank.values())
                .filter(winning -> winning.match(count, bonus))
                .findFirst()
                .orElse(NONE);
    }

    private boolean match(int count, boolean bonus) {
        if (this.bonus) {
            return bonus && this.matchCount == count;
        }
        return this.matchCount == count;
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
