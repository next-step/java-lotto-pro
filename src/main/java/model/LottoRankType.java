package model;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRankType {
    RANK_ONE(6, 2_000_000_000),
    RANK_TWO(5, 30_000_000, true),
    RANK_THREE(5, 1_500_000, true),
    RANK_FOUR(4, 50_000, false),
    RANK_FIVE(3, 5_000),
    RANK_FAIL(0, 0);

    private final int count;
    private final int winMoney;
    private boolean matchBonus;

    LottoRankType(int sameCount, int winMoney) {
        this.count = sameCount;
        this.winMoney = winMoney;
    }

    LottoRankType(int sameCount, int winMoney, boolean matchBonus) {
        this.count = sameCount;
        this.winMoney = winMoney;
        this.matchBonus = matchBonus;
    }

    public static LottoRankType convertRank(int winNumberCount) {
        return convertRank(winNumberCount, false);
    }

    public static LottoRankType convertRank(int countOfContain, boolean isContainBonusNumber) {
        Optional<LottoRankType> result = Arrays.stream(LottoRankType.values())
                .filter(rankType -> rankType.isMatch(countOfContain, isContainBonusNumber))
                .findFirst();

        return result.orElse(RANK_FAIL);
    }

    private boolean isMatch(int countOfContain, boolean isContainBonusNumber) {
        return this.count == countOfContain && this.matchBonus == isContainBonusNumber;
    }

    public int getWinMoney() {
        return winMoney;
    }

    public int getCount() {
        return count;
    }

    public boolean isSameRankType(LottoRankType rankType) {
        return this == rankType;
    }

    public boolean isFail() {
        return this == RANK_FAIL;
    }
}
