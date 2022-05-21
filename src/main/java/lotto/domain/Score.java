package lotto.domain;

import java.util.Arrays;

public enum Score {
    ZERO(0, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private int sameNumberCount;

    private int prize;

    Score(int sameNumberCount, int prize) {
        this.sameNumberCount = sameNumberCount;
        this.prize = prize;
    }

    public static int getPrizeBySameNumberCount(int sameNumberCount) {
        return Arrays.stream(Score.values())
                .filter(score -> score.getSameNumberCount() == sameNumberCount)
                .findFirst()
                .orElse(ZERO).getPrize();
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }

    public int getPrize() {
        return prize;
    }

}
