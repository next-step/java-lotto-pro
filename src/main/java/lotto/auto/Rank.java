package lotto.auto;

import java.util.Arrays;

public enum Rank {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int match;
    private final int money;

    Rank(int match, int money) {
        this.match = match;
        this.money = money;
    }

    public static int getRank(int numberOfMatch) {
        return Arrays.stream(values())
                .filter(Rank -> Rank.match == numberOfMatch)
                .findFirst()
                .get()
                .money;
    }

    public static int getMoney(int numberOfMatch, int cnt) {
        if (cnt > 0) {
            return (Arrays.stream(values())
                    .filter(Rank -> Rank.match == numberOfMatch)
                    .findFirst()
                    .get()
                    .money) * cnt;
        }
        return 0;
    }
}
