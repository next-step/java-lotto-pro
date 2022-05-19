package lotto;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    LOSE(0, 0);

    private final int count;
    private final int winningMoney;

    Rank(int count, int winningMoney) {
        this.count = count;
        this.winningMoney = winningMoney;
    }

    public static Rank fromCountAndIsBonusMatch(int count, boolean isBonusMatch) {
        return Arrays.stream(values())
                .filter(value -> value.getCount() == count)
                .filter(value -> checkSecond(value, isBonusMatch))
                .findFirst().orElse(LOSE);
    }

    private static boolean checkSecond(Rank value, boolean isBonusMatch) {
        if (SECOND.equals(value)) {
            return isBonusMatch;
        }
        return true;
    }

    public int getCount() {
        return count;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

}
