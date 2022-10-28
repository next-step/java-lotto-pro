package lotto;

import java.util.Arrays;

public enum Rank {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000),
    NONE(0, 0);

    private final int count;
    private final int prize;

    Rank(int count, int prize) {
        this.count = count;
        this.prize = prize;
    }

    public static Rank valueOf(int count) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.count == count)
                .findFirst()
                .orElse(NONE);
    }

    public int getCount() {
        return this.count;
    }

    public int getPrize() {
        return this.prize;
    }
}
