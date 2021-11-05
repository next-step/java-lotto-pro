package lotto;

import java.util.Arrays;

public enum WinResult {

    THREE_MATCHED(3, 5000),
    FOUR_MATCHED(4, 50000),
    FIVE_MATCHED(5, 1500000),
    SIX_MATCHED(6, 2000000000),
    DEFEAT(-1, 0);

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
                .orElse(DEFEAT);
    }
}
