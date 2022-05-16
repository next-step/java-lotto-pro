package lotto_auto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5000),
    NOTHING(0,0);

    private final int matchedCount;
    private final int winnings;

    LottoRank(int matchedCount, int winnings) {
        this.matchedCount = matchedCount;
        this.winnings = winnings;
    }

    public int matchedCount() {
        return matchedCount;
    }

    public int winnings() {
        return winnings;
    }

    public static LottoRank getLottoRuleFromMatchedCount(int count) {
        Optional<LottoRank> rank = Arrays.stream(LottoRank.values())
                .filter(r -> r.matchedCount == count)
                .findAny();
        return rank.orElse(NOTHING);
    }

    public static List<LottoRank> valuesTheLowestOrder() {
        return Arrays.asList(FOURTH, THIRD, SECOND, FIRST);
    }

}
