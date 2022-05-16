package domain;

import java.util.Arrays;

public enum Reward {

    FIRST(6, new Money(200_000_000L)),
    SECOND(5, new Money(15_000_00)),
    THIRD(4, new Money(50_000)),
    FOURTH(3, new Money(5_000)),
    MISS(0, new Money(0));

    private final int numberOfMatches;
    private final Money prize;

    Reward(int numberOfMatches, Money prize) {
        this.numberOfMatches = numberOfMatches;
        this.prize = prize;
    }

    public static Reward of(int matches) {
        return Arrays.stream(values())
                .filter(reward -> reward.numberOfMatches == matches)
                .findAny()
                .orElse(MISS);
    }

    public Money getPrize() {
        return prize;
    }
}
