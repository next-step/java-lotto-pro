package lotto;

import java.util.Arrays;

public enum WinningResult {
    NOT_MATCH(0),
    MATCH_ONE(1),
    MATCH_TWO(2),
    MATCH_THREE(3),
    MATCH_FOUR(4),
    MATCH_FIVE(5),
    MATCH_SIX(6);

    private final int matchCount;

    WinningResult(int matchCount) {
        this.matchCount = matchCount;
    }

    public static WinningResult getResultByMatchCount(int matchCount) {
        return Arrays.stream(WinningResult.values())
                .filter(it -> it.matchCount == matchCount)
                .findFirst()
                .orElse(NOT_MATCH);
    }
}
