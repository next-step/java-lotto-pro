package domain;

import java.util.Arrays;

public enum Reward {

    FIRST(6, 200_000_000),
    SECOND(5, 15_000_00),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private final int numberOfMatches;
    private final int prize;

    Reward(int numberOfMatches, int prize) {
        this.numberOfMatches = numberOfMatches;
        this.prize = prize;
    }

    public static Reward of(int matches) {
        return Arrays.stream(values())
                .filter(reward -> reward.numberOfMatches == matches)
                .findAny()
                .orElse(MISS);
    }
}
