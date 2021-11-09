package lotto.domain;

import java.util.Arrays;

public enum LottoReward {

    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 30_000_000),
    THIRD_PLACE(5, 1_500_000),
    FOURTH_PLACE(4, 50_000),
    FIFTH_PLACE(3, 5_000),
    MISS(0, 0);

    private final int matchCount;
    private final int rewardMoney;

    LottoReward(int matchCount, int rewardMoney) {
        this.matchCount = matchCount;
        this.rewardMoney = rewardMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public static LottoReward getLottoReward(int matchCount, boolean matchBonus) {
        if (isSameMathCount(matchCount, SECOND_PLACE.matchCount)) {
            return getSecondOrThird(matchBonus);
        }
        return findLottoReward(matchCount);
    }

    private static LottoReward findLottoReward(int matchCount) {
        return Arrays.stream(LottoReward.values())
                .filter(l -> isSameMathCount(l.matchCount, matchCount))
                .findAny()
                .orElse(MISS);
    }

    private static boolean isSameMathCount(int matchCount, int secondMatchCount) {
        return matchCount == secondMatchCount;
    }

    private static LottoReward getSecondOrThird(boolean matchBonus) {
        if (matchBonus) {
            return SECOND_PLACE;
        }
        return THIRD_PLACE;
    }
}
