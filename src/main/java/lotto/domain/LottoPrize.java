package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    FIRST (6, 2_000_000_000, false),
    SECOND (5, 30_000_000, true),
    THIRD (5, 1_500_000, false),
    FOURTH (4, 50_000, false),
    FIFTH (3, 5000, false),
    NONE (0, 0, false);

    private static final long SECOND_OR_THIRD_COUNT = 5;
    private int count;
    private int money;
    private boolean bonus;

    LottoPrize(int count, int money, boolean bonus) {
        this.count = count;
        this.money = money;
        this.bonus = bonus;
    }

    public static LottoPrize findPrize(long matchCount, boolean matchBonus) {
        LottoPrize lottoPrize = Arrays.stream(LottoPrize.values())
                                    .filter(l -> l.matchPrize(matchCount, matchBonus))
                                    .findFirst()
                                    .orElse(NONE);
        return lottoPrize;
    }

    private boolean matchPrize(long matchCount, boolean matchBonus) {
        if (matchCount == SECOND_OR_THIRD_COUNT) {
            return count == matchCount && bonus == matchBonus;
        }
        return count == matchCount;
    }

    public int getCount() {
        return count;
    }

    public int getMoney() {
        return money;
    }
}
