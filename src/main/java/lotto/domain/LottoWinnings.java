package lotto.domain;

import java.util.Arrays;

public enum LottoWinnings {
    THREE(3, 5000), FOUR(4, 50000), FIVE(5, 1500000), ALL(6, 2000000000), NONE(0, 0);

    private final int count;
    private final int winnings;

    LottoWinnings(int count, int winnings) {
        this.count = count;
        this.winnings = winnings;
    }

    public int getCount() {
        return count;
    }

    public int getWinnings() {
        return winnings;
    }

    public static LottoWinnings getWinningsByCount(int count) {
        return Arrays.stream(LottoWinnings.values()).filter(x -> x.count == count).findFirst()
            .orElse(NONE);
    }

    public boolean isNone() {
        return this == NONE;
    }
}
