package lotto.domain;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public enum WinningMoney {

    NONE("0개 일치", 0, 0, asList(true, false), false),
    THREE_MATCH("3개 일치", 5_000L, 3, asList(true, false), true),
    FOUR_MATCH("4개 일치", 50_000L, 4, asList(true, false), true),
    FIVE_MATCH("5개 일치", 1_500_000L, 5, singletonList(false), true),
    FIVE_MATCH_AND_BONUS_BALL_MATCH("5개 일치, 보너스 볼 일치", 30_000_000, 5, singletonList(true), true),
    SIX_MATCH("6개 일치", 2_000_000_000L, 6, asList(true, false), true);

    private final int count;
    private final long money;
    private final String message;
    private final List<Boolean> isMatchBonusBalls;
    private final boolean isShow;

    WinningMoney(String message, long money, int count, List<Boolean> isMatchBonusBalls, boolean isShow) {
        this.message = message;
        this.money = money;
        this.count = count;
        this.isMatchBonusBalls = isMatchBonusBalls;
        this.isShow = isShow;
    }

    public long getMoney() {
        return money;
    }

    public int getCount() {
        return count;
    }

    public String getMessage() {
        return message;
    }

    public static WinningMoney find(int count, boolean isMatchBonusBall) {
        return Arrays
                .stream(values())
                .filter(winningMoney -> winningMoney.count == count && winningMoney.getIsMatchBonusBalls().contains(isMatchBonusBall))
                .findFirst()
                .orElse(NONE);
    }

    public List<Boolean> getIsMatchBonusBalls() {
        return this.isMatchBonusBalls;
    }

    public boolean isShow() {
        return this.isShow;
    }
}
