package lotto.model;

import java.util.Arrays;

public enum Rank {
    NONE(5L, 0, 0),
    FOURTH(4L, 3, 5000),
    THIRD(3L, 4, 50000),
    SECOND(2L, 5, 1500000),
    FIRST(1L, 6, 2000000000);

    private final long rank;
    private final long matchCount;
    private final long price;

    Rank(long rank, long matchCount, long price) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.price = price;
    }

    public long getMatchCount() {
        return matchCount;
    }

    public long getPrice() {
        return price;
    }

    public static Rank getRank(long count) {
        return Arrays.stream(Rank.values()).filter(value -> value.matchCount == count)
                .findFirst().orElse(Rank.NONE);
    }
}
