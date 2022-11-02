package step3.domain;

import java.util.Arrays;

public enum WinningLottoRank {
    FIRST(6, 2_000_000_000)
    , SECOND(5, 1_500_000)
    , THIRD(4, 50_000)
    , FOURTH(3, 5_000)
    , FIFTH(0, 0);

    private final int matchCount;
    private final int reward;

    WinningLottoRank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }

    public static WinningLottoRank getRank(int matchCount) {
        return Arrays.stream(WinningLottoRank.values())
                .filter(v -> v.matchCount == matchCount)
                .findFirst()
                .orElse(FIFTH);
    }

    @Override
    public String toString() {
        return matchCount + "개 일치 (" + reward + "원)";
    }
}
