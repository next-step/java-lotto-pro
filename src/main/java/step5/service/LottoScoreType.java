package step5.service;

import java.util.Arrays;

public enum LottoScoreType {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_BONUS(5, 30000000),
    SIX(6, 2000000000),
    ;

    public static final int BONUS_MEET_COUNT = 5;
    private final int score;
    private final int money;

    LottoScoreType(int score, int money) {
        this.score = score;
        this.money = money;
    }

    public static LottoScoreType getByScore(int score) {
        return Arrays.stream(values())
                .filter(scoreType -> scoreType.getScore() == score)
                .findFirst()
                .orElse(null);
    }

    public static LottoScoreType getByScore(int score, boolean isBonus) {
        if (score == BONUS_MEET_COUNT && isBonus) {
            return LottoScoreType.FIVE_BONUS;
        }

        return Arrays.stream(values())
                .filter(scoreType -> scoreType.getScore() == score)
                .findFirst()
                .orElse(null);
    }

    public int getScore() {
        return score;
    }

    public int getMoney() {
        return money;
    }
}
