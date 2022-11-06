package lotto.domain;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public enum WinningMoney {

    NONE(0, 0, asList(true, false)),
    THREE_MATCH(5_000L, 3, asList(true, false)),
    FOUR_MATCH(50_000L, 4, asList(true, false)),
    FIVE_MATCH(1_500_000L, 5, singletonList(false)),
    FIVE_MATCH_AND_BONUS_BALL_MATCH(30_000_000, 5, singletonList(true)),
    SIX_MATCH(2_000_000_000L, 6, asList(true, false));

    private final int count;
    private final long money;
    private final List<Boolean> isMatchBonusBall;

    WinningMoney(long money, int count, List<Boolean> isMatchBonusBall) {
        this.money = money;
        this.count = count;
        this.isMatchBonusBall = isMatchBonusBall;
    }

    public long getMoney() {
        return money;
    }

    public int getCount() {
        return count;
    }

    public static WinningMoney find(int count, boolean isMatchBonusBall) {
        return Arrays
                .stream(values())
                .filter(winningMoney -> winningMoney.count == count && winningMoney.isMatchBonusBall.contains(isMatchBonusBall))
                .findFirst()
                .orElse(NONE);
    }
}
