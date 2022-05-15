package lotto.domain;

import java.util.Arrays;

public enum LottoWinner {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FORTH(3, 5000),
    NOT_WINNER(-1, 0);
    ;

    private int rightCount;
    private long winnerMoney;

    LottoWinner(int rightCount, long winnerMoney) {
        this.rightCount = rightCount;
        this.winnerMoney = winnerMoney;
    }

    public static LottoWinner findLottoWinnerByRightCount(int rightCount) {
        return Arrays.stream(LottoWinner.values())
                .filter(winner -> winner.rightCount == rightCount)
                .findAny()
                .orElse(NOT_WINNER);
    }

    public long getWinnerMoney() {
        return winnerMoney;
    }
}
