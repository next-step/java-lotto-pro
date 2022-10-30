package lotto.enums;

import java.util.Arrays;

public enum LottoRank {

    NONE(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private final int matchCount;
    private final int reward;
    private final boolean bonus;

    LottoRank(int matchCount, int reward, boolean bonus) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.bonus = bonus;
    }

    // TODO: 기존 코드(추후 삭제)
    public static LottoRank findLottoRank(int matchNumberCount) {
        return Arrays.stream(LottoRank.values())
                .filter(item -> item.matchCount == matchNumberCount)
                .findFirst()
                .orElse(LottoRank.NONE);
    }

    public static LottoRank findLottoRank(int matchNumberCount, boolean bonus) {
        return Arrays.stream(LottoRank.values())
                .filter(item -> matchLottoRank(item, matchNumberCount, bonus))
                .findAny()
                .orElse(LottoRank.NONE);
    }

    private static boolean matchLottoRank(LottoRank lottoRank, int matchCount, boolean bonus) {
        return lottoRank.matchCount == matchCount && lottoRank.bonus == isBonus(matchCount, bonus);
    }

    private static boolean isBonus(int matchNumberCount, boolean bonus) {
        return LottoRank.SECOND.matchCount == matchNumberCount && bonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

}