package lotto.model;

import java.util.stream.Stream;

public enum Rank {
    FIRST("1등", 6, 2_000_000_000),
    SECOND("2등", 5, 1_500_000),
    THIRD("3등", 4, 50_000),
    FOURTH("4등", 3, 5_000),
    NOTHING("꽝", 0, 0);

    private final String name;
    private final int matchedCount;
    private final long prize;

    Rank(String name, int matchedCount, int prize) {
        this.name = name;
        this.matchedCount = matchedCount;
        this.prize = prize;
    }

    public static Rank getRank(Long matchedCount) {
        return getRank(matchedCount.intValue());
    }

    public static Rank getRank(int matchedCount) {
        return Stream.of(Rank.values())
                .filter(rank -> rank.matchedCount == matchedCount)
                .findFirst()
                .orElse(Rank.NOTHING);
    }

    public String getName() {
        return name;
    }

    public long getPrize() {
        return prize;
    }
}