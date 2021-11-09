package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    FIRST (6, 2_000_000_000),
    SECOND (5, 30_000_000),
    THIRD (5, 1_500_000),
    FOURTH (4, 50_000),
    FIFTH (3, 5000),
    NONE (0, 0);

    private int count;
    private int money;

    LottoPrize(int count, int money) {
        this.count = count;
        this.money = money;
    }

    public static LottoPrize findPrize(long matchCount, boolean matchBonus) {
        LottoPrize lottoPrize = Arrays.stream(LottoPrize.values())
                                    .filter(l -> l.isMatchCount(matchCount))
                                    .findFirst()
                                    .orElse(NONE);
        if (!matchBonus && lottoPrize.equals(SECOND)) {
            return THIRD;
        }
        return lottoPrize;
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
