package lotto.domain;

import java.util.stream.Stream;

public enum Reward {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int match;
    private final int reward;

    Reward(int match, int reward) {
        this.match = match;
        this.reward = reward;
    }

    public static int find(int match) {
        return stream().filter(reward -> reward.match == match)
                       .findFirst()
                       .get().reward;
    }

    private static Stream<Reward> stream() {
        return Stream.of(Reward.values());
    }
}
