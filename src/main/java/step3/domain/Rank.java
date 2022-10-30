package step3.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5000),
    NOTHING(0,0);

    private final int count;
    private final int winnings;

    Rank(int count, int winnings) {
        this.count = count;
        this.winnings = winnings;
    }

    public static Rank from(int count) {
        Optional<Rank> rank = Arrays.stream(Rank.values())
            .filter(r -> r.count == count)
            .findAny();
        return rank.orElse(NOTHING);
    }

}