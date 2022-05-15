package lotto;

import java.util.Arrays;

public enum Rank {

    _1ST(6, 2000000000),
    _2ST(5, 1500000),
    _3ST(4, 50000),
    _4ST(3, 5000),
    ZERO(0, 0);

    private final int count;
    private final int winningMoney;

    Rank(int count, int winningMoney) {
        this.count = count;
        this.winningMoney = winningMoney;
    }

    public static Rank from(int count) {
        return Arrays.stream(values()).filter(value -> value.count == count).findFirst().orElse(ZERO);
    }

    public int getCount() {
        return count;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

}
