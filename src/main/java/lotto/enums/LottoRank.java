package lotto.enums;

import java.util.Arrays;

public enum LottoRank {

    NONE(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private final int matchNumberCount;
    private final int reward;

    LottoRank(int matchNumberCount, int reward) {
        this.matchNumberCount = matchNumberCount;
        this.reward = reward;
    }

    public static LottoRank findLottoRank(int matchNumberCount) {
        return Arrays.stream(LottoRank.values())
                .filter(item -> item.matchNumberCount == matchNumberCount)
                .findFirst()
                .orElse(LottoRank.NONE);
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public int getReward() {
        return reward;
    }

}