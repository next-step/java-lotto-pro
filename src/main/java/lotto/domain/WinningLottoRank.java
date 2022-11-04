package lotto.domain;

import java.util.Arrays;

public enum WinningLottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    public static final int MATCH_COUNT_FOR_SECOND_OR_THIRD = 5;
    private final int matchCount;
    private final int reward;

    WinningLottoRank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }

    public static WinningLottoRank getRank(int matchCount, boolean matchBonus) {
        if (matchCount == MATCH_COUNT_FOR_SECOND_OR_THIRD) {
            return matchBonus ? SECOND : THIRD;
        }
        return Arrays.stream(values())
                .filter(v -> v.matchCount == matchCount)
                .findFirst()
                .orElse(MISS);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(matchCount);
        sb.append("개 일치");
        if (this == SECOND) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(" (");
        sb.append(reward);
        sb.append("원)");

        return sb.toString();
    }
}
