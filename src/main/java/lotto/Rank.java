package lotto;

import java.util.Arrays;

public enum Rank {

    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000),
    LOSE(0, 0);

    private final int count;
    private final int winningMoney;

    Rank(int count, int winningMoney) {
        this.count = count;
        this.winningMoney = winningMoney;
    }

    public static Rank fromCountAndIsBonusMatch(int count, boolean isBonusMatch) {
        if (SECOND.getCount() == count && isBonusMatch) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.getCount() == count)
                .findFirst()
                .orElse(LOSE);
    }

    public int getCount() {
        return count;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

}
