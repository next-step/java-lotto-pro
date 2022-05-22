package lotto.domain;

import java.util.Arrays;

public enum LottoWinner {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NOT_WINNER(-1, 0);
    ;

    private int rightCount;
    private long winnerMoney;

    LottoWinner(int rightCount, long winnerMoney) {
        this.rightCount = rightCount;
        this.winnerMoney = winnerMoney;
    }

    public static LottoWinner findLottoWinnerByRightCount(int rightCount, boolean matchBonus) {
        if (isThird(rightCount, matchBonus)) {
            return THIRD;
        }

        return Arrays.stream(LottoWinner.values())
                .filter(winner -> winner.rightCount == rightCount)
                .findAny()
                .orElse(NOT_WINNER);
    }

    private static boolean isThird(int rightCount, boolean matchBonus) {
        return rightCount == THIRD.getRightCount() && !matchBonus;
    }

    public long getWinnerMoney() {
        return winnerMoney;
    }

    public int getRightCount() {
        return rightCount;
    }
}
