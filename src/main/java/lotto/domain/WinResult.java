package lotto.domain;

import java.util.Arrays;

public enum WinResult {

    THREE_MATCHED(3, 5_000),
    FOUR_MATCHED(4, 50_000),
    FIVE_MATCHED(5, 1_500_000),
    SIX_MATCHED(6, 2_000_000_000);

    private final int count;
    private final int prize;

    WinResult(int count, int prize) {
        this.count = count;
        this.prize = prize;
    }

    static WinResult fromCount(int count) {
        return Arrays.stream(values())
                .filter(it -> it.count == count)
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }
}
