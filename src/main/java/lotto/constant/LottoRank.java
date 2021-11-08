package lotto.constant;

import java.util.Arrays;

public enum LottoRank {
    NONE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 5_0000),
    THIRD(5, 150_0000),
    FIRST(6, 20_0000_0000);

    private final int matchingCount;
    private final int price;

    LottoRank(int matchingCount, int price) {
        this.matchingCount = matchingCount;
        this.price = price;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrice() {
        return price;
    }

    public static LottoRank findRank(int matchingCount) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchingCount == matchingCount)
                .findFirst()
                .orElse(LottoRank.NONE);
    }
}
