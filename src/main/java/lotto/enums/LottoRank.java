package lotto.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    LOSE(-1,0);

    private int matchedCount;
    private int price;

    public static final int RANK_SECOND_MATCHED_COUNT = 5;

    LottoRank(int matchedCount, int price) {
        this.matchedCount = matchedCount;
        this.price = price;
    }

    public static LottoRank valueOf(int matchedCount, boolean bonusMatched) {
        if (bonusMatched) {
            return rankWithBonus(matchedCount);
        }
        return rankWithoutBonus(matchedCount);
    }

    private static LottoRank rankWithBonus(int matchedCount) {
        if (matchedCount == RANK_SECOND_MATCHED_COUNT) {
            return SECOND;
        }
        return rankWithoutBonus(matchedCount);
    }

    public static LottoRank rankWithoutBonus(int matchedCount) {
        return Arrays.stream(LottoRank.values())
                .filter(r -> r.getMatchedCount() == matchedCount)
                .filter(r -> !r.equals(SECOND))
                .findAny()
                .orElse(LOSE);
    }

    public static List<LottoRank> rankListWithReverseOrder() {
        return Collections.unmodifiableList(Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST));
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrice() {
        return price;
    }
}
