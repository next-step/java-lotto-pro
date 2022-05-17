package lotto.type;

import java.util.Arrays;

public enum LottoRank {

    FIST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE(0, 0);
    private final int matchedCount;
    private final int price;

    LottoRank(int matchedCount, int price) {
        this.matchedCount = matchedCount;
        this.price = price;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrice() {
        return price;
    }

    public static LottoRank findLottoRankByMatchedCount(int matchedCount) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.getMatchedCount() == matchedCount)
                .findFirst()
                .orElse(NONE);
    }
}
