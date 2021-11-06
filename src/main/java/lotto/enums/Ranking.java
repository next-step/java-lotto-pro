package lotto.enums;

import java.util.Arrays;

public enum Ranking {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FORTH(3, 5_000),
    MISS(0,0);

    private final int correct;
    private final int amount;

    Ranking(int correct, int amount) {
        this.correct = correct;
        this.amount = amount;
    }

    public static Ranking findCorrect(final int count) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> count == ranking.correct)
                .findAny()
                .orElse(MISS);
    }

    public int getAmount() {
        return this.amount;
    }

    public int getCorrect() {
        return this.correct;
    }

    public int totalWinningMoney(final int hitCount) {
        return this.amount * hitCount;
    }
}
