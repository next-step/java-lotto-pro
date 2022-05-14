package lotto_auto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
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

    public static LottoRank matches(Lotto o1, Lotto o2) {
        List<Integer> o1Numbers = o1.getLottoNumbers();
        List<Integer> o2Numbers = o2.getLottoNumbers();
        o1Numbers.retainAll(o2Numbers);

        return LottoRank.getLottoRuleFromMatchedCount(o1Numbers.size());
    }

    public static List<LottoRank> valuesTheLowestOrder() {
        return Arrays.asList(FOURTH, THIRD, SECOND, FIRST);
    }

}
