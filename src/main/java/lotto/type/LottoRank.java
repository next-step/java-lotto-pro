package lotto.type;

import java.util.Arrays;

public enum LottoRank {

    FIST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    NONE(0, 0, false);
    private final int matchedCount;
    private final int price;
    private final boolean isBonusBallCheck;

    LottoRank(int matchedCount, int price, boolean isBonusBallCheck) {
        this.matchedCount = matchedCount;
        this.price = price;
        this.isBonusBallCheck = isBonusBallCheck;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrice() {
        return price;
    }

    public boolean isBonusBallCheck() {
        return isBonusBallCheck;
    }

    public static LottoRank findLottoRankByMatchedCount(int matchedCount, boolean isMatchedBonusBall) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.getMatchedCount() == matchedCount && lottoRank.isBonusBallCheck == isMatchedBonusBall)
                .findFirst()
                .orElse(NONE);
    }
}
