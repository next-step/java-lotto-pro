package lotto.domain;

import java.util.Arrays;

public enum WinResult {

    FIRST(6, 2_000_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NOT_MATCHED(-1, 0);

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
                .orElse(NOT_MATCHED);
    }

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }
}
