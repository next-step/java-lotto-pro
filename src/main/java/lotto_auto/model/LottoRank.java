package lotto_auto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3,5_000),
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

    public static LottoRank getLottoRuleFromMatchedCount(int count, boolean matchedBonusBall) {
        Optional<LottoRank> rank = Arrays.stream(LottoRank.values())
                .filter(r -> r.matchedCount == count)
                .findAny();

        LottoRank resultRank = rank.orElse(NOTHING);

        if (resultRank.matchedCount != 5) {
            return resultRank;
        }

        return resultRank.isSecondRank(matchedBonusBall) ? SECOND : THIRD;
    }

    private boolean isSecondRank(boolean matchedBonusBall) {
        return this.matchedCount == 5 && matchedBonusBall;
    }


    public static List<LottoRank> valuesTheLowestOrder() {
        return Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }

}
