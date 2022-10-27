package lotto.win;

import lotto.money.Money;

public enum WinRanking {
    FIRST(6, Money.from(2000000000)),
    SECOND(5, Money.from(1500000)),
    THIRD(4, Money.from(50000)),
    FOURTH(3, Money.from(5000)),
    ;

    private final int matchCount;
    private final Money winningMoney;

    WinRanking(int matchCount, Money winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static boolean isWin(int matchCount) {
        return matchCount >= FOURTH.matchCount && matchCount <= FIRST.matchCount;
    }
}
