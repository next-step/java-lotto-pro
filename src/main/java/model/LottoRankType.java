package model;

import java.util.Arrays;

public enum LottoRankType {
    RANK_ONE(6, 2_000_000_000, false),
    RANK_TWO(5, 30_000_000, true),
    RANK_THREE(5, 1_500_000, false),
    RANK_FOUR(4, 50_000, false),
    RANK_FIVE(3, 5_000, false),
    RANK_FAIL(0, 0, false);

    private final int count;
    private final int winMoney;
    private final boolean isBonusBall;

    LottoRankType(int sameCount, int winMoney, boolean isBonusBall) {
        this.count = sameCount;
        this.winMoney = winMoney;
        this.isBonusBall = isBonusBall;
    }

    public static LottoRankType convertRank(int countOfContain, boolean isContainBonusNumber) {
        LottoRankType lottoRankType = Arrays.stream(LottoRankType.values())
                .filter(rankType -> rankType.isSame(countOfContain))
                .findFirst()
                .orElse(RANK_FAIL);

        return convertPossibleRankTwo(lottoRankType, isContainBonusNumber);
    }

    private static LottoRankType convertPossibleRankTwo(LottoRankType lottoRankType, boolean isContainBonusNumber) {
        if (!lottoRankType.isCountFive()) {
            return lottoRankType;
        }

        if (isContainBonusNumber) {
            return LottoRankType.RANK_TWO;
        }

        return LottoRankType.RANK_THREE;
    }

    private boolean isCountFive() {
        return this.count == 5;
    }

    private boolean isSame(int countOfContain) {
        return this.count == countOfContain;
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

    public boolean isBonusBall() {
        return isBonusBall;
    }
}
