package lotto;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    LOSE(0, 0);

    private final int count;
    private final int winningMoney;

    Rank(int count, int winningMoney) {
        this.count = count;
        this.winningMoney = winningMoney;
    }

    public static Rank from(int count) {
        return Arrays.stream(values()).filter(value -> value.count == count).findFirst().orElse(LOSE);
    }

    public int getCount() {
        return count;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

}
