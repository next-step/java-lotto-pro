package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    NONE (0, 0),
    FOURTH (3, 5000),
    THIRD (4, 50_000),
    SECOND (5, 1_500_000),
    FIRST (6, 2_000_000_000);

    private int count;
    private int money;

    LottoPrize(int count, int money) {
        this.count = count;
        this.money = money;
    }

    public static LottoPrize findPrize(long matchCount) {
        return Arrays.stream(LottoPrize.values())
                .filter(l -> l.isMatchCount(matchCount))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isMatchCount(long matchCount) {
        return count == matchCount;
    }

    public int getCount() {
        return count;
    }

    public int getMoney() {
        return money;
    }
}
