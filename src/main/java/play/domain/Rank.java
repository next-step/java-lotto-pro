package play.domain;

import java.util.Arrays;

public enum Rank {
    NOTHING(0, 0),
    FORTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private final int containsCount;
    private final int money;

    Rank(int containsCount, int money) {
        this.containsCount = containsCount;
        this.money = money;
    }

    public static Rank getRank(int matchingCount) {
        return Arrays.stream(Rank.values())
                .filter(rankCode -> rankCode.containsCount == matchingCount)
                .findAny()
                .orElse(NOTHING);
    }

    public int getMoney() {
        return this.money;
    }

    public int containsCount() {
        return this.containsCount;
    }
}
