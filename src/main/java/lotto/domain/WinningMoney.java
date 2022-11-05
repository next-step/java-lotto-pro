package lotto.domain;

import java.util.Arrays;

public enum WinningMoney {

    THREE_MATCH("3개 일치", 5_000L, 3),
    FOUR_MATCH("4개 일치", 50_000L, 4),
    FIVE_MATCH("5개 일치", 1_500_000L, 5),
    SIX_MATCH("6개 일치", 2_000_000_000L, 6),
    NONE("해당없음", 0, 0);

    private final int count;
    private long money;
    private String message;

    WinningMoney(String message, long money, int count) {
        this.message = message;
        this.money = money;
        this.count = count;
    }

    public long getMoney() {
        return money;
    }

    public static WinningMoney find(int count) {
        return Arrays.stream(values())
                .filter(winningMoney -> winningMoney.count == count)
                .findFirst()
                .orElse(NONE);
    }
}
