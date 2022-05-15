package lotto.enums;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    LOSE(-1,0);

    private int matchedCount;
    private int price;

    LottoRank(int matchedCount, int price) {
        this.matchedCount = matchedCount;
        this.price = price;
    }

    public static LottoRank matchRank(int matchedCount) {
        return Arrays.stream(LottoRank.values())
                .filter(r -> r.getMatchedCount() == matchedCount)
                .findAny()
                .orElse(LOSE);
    }

    public static List<LottoRank> rankListWithReverseOrder() {
        return Arrays.asList(FOURTH, THIRD, SECOND, FIRST);
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrice() {
        return price;
    }
}
