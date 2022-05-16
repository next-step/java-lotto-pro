package lotto.type;

import java.util.Arrays;

public enum LottoRank {

    FIST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    FIFTH(2, 0),
    SIXTH(1, 0),
    NONE(0, 5000);

    public static final String ERROR_INVALID_MATCHED_COUNT_MESSAGE = "[ERROR] 번호 일치 갯수가 유효하지 않습니다.";
    private int matchedCount;
    private int price;

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
