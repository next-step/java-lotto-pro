package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int hits;
    private final int cashPrize;
//    Predicate<LottoRank> isPositive

    LottoRank(int hits, int cashPrize) {
        this.hits = hits;
        this.cashPrize = cashPrize;
    }

    public int getHits() {
        return hits;
    }

    public int getCashPrize() {
        return cashPrize;
    }

    public static LottoRank findByHits(int hits, boolean hasBonus) {
        return filterBonusLottoRank(hasBonus)
                .filter(lottoRank -> lottoRank.hits == hits)
                .findAny()
                .orElse(MISS);
    }

    private static Stream<LottoRank> filterBonusLottoRank(boolean hasBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> (hasBonus && lottoRank != THIRD) || (!hasBonus && lottoRank != SECOND));
    }
}
