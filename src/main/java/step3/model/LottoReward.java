package step3.model;

import java.util.Arrays;

public enum LottoReward {
    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int matchNum;
    private final int money;

    LottoReward(int matchNum, int money) {
        this.matchNum = matchNum;
        this.money = money;
    }

    public static LottoReward getWinMoney(int matchNum) {
        return Arrays.stream(values())
                .filter(lottoReward -> lottoReward.getMatchNum() == matchNum)
                .findFirst()
                .orElse(ZERO);
    }

    public int getMatchNum() {
        return matchNum;
    }

    public int getMoney() {
        return money;
    }
}
