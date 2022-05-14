package lotto;

import java.util.Arrays;

public enum Rank {
     FIRST(6, 2_000_000_000)
    , SECOND(5, 1_500_000)
    , THIRD(4, 50_000)
    , FOUR(3, 5_000)
    ;

    private final int matchingCount;
    private final int prize;

    Rank(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public static Rank of(int matchCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchingCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 숫자와 일치하는 당첨 순위가 없습니다."));
    }
}
