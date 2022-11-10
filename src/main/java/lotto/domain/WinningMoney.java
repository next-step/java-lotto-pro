package lotto.domain;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public enum WinningMoney {

    NONE("0개 일치", 0, 0, asList(true, false)),
    THREE_MATCH("3개 일치", 5_000L, 3, asList(true, false)),
    FOUR_MATCH("4개 일치", 50_000L, 4, asList(true, false)),
    FIVE_MATCH("5개 일치", 1_500_000L, 5, singletonList(false)),
    FIVE_MATCH_AND_BONUS_BALL_MATCH("5개 일치, 보너스 볼 일치", 30_000_000, 5, singletonList(true)),
    SIX_MATCH("6개 일치", 2_000_000_000L, 6, asList(true, false));

    private final int count;
    private final long money;
    private final String message;
    private final List<Boolean> isMatchBonusBalls;

    WinningMoney(String message, long money, int count, List<Boolean> isMatchBonusBalls) {
        this.message = message;
        this.money = money;
        this.count = count;
        this.isMatchBonusBalls = isMatchBonusBalls;
    }

    public long getMoney() {
        return money;
    }

    public String getMessage() {
        return message;
    }

    public static WinningMoney find(int count, boolean isMatchBonusBall) {
        return Arrays.stream(values())
                .filter(winningMoney -> winningMoney.count == count && winningMoney.isMatchBonusBalls.contains(isMatchBonusBall))
                .findFirst()
                .orElse(NONE);
    }

    public boolean isShow() {
        return this.count >= 3;
    }
}
