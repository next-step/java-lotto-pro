package step3.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoReward {
    MISS(0, 0, false),
    THREE(5_000, 3, false),
    FOUR(50_000, 4, false),
    FIVE(1_500_000, 5, false),
    FIVE_BONUS(30_000_000, 5, true),
    SIX(2_000_000_000, 6, false);

    private final int reward;
    private final int matchCount;
    private final boolean isBonus;

    LottoReward(int reward, int matchCount, boolean isBonus) {
        this.reward = reward;
        this.matchCount = matchCount;
        this.isBonus = isBonus;
    }

    public int getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public static LottoReward valueOf(int matchCount, boolean matchBonus) {
        if (matchBonus == true && matchCount == 5) {
            return LottoReward.FIVE_BONUS;
        }

        LottoReward[] lottoRewards = LottoReward.values();
        List<LottoReward> matchReward = Arrays.stream(lottoRewards).filter(
            lottoReward -> lottoReward.getMatchCount() == matchCount && lottoReward.isBonus == false
        ).collect(Collectors.toList());
        if (matchReward.size() == 0) {
            return LottoReward.MISS;
        }
        return matchReward.get(0);
    }

}
