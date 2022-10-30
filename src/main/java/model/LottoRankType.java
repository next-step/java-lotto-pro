package model;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRankType {
    RANK_ONE(6, 2_000_000_000),
    RANK_TWO(5, 1_500_000),
    RANK_THREE(4, 50_000),
    RANK_FOUR(3, 5_000),
    RANK_FAIL(0, 0);

    private final int count;
    private final int winMoney;

    LottoRankType(int sameCount, int winMoney) {
        this.count = sameCount;
        this.winMoney = winMoney;
    }

    public static LottoRankType convertRank(int winNumberCount) {
        Optional<LottoRankType> result = Arrays.stream(LottoRankType.values())
                .filter(s -> s.count == winNumberCount).findFirst();
        return result.orElse(RANK_FAIL);
    }

    public int getWinMoney() {
        return winMoney;
    }

    public int getCount() {
        return count;
    }
}
