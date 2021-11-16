package nextstep.lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MatchCount implements Comparable<MatchCount> {

    private final LottoWinningPrice lottoWinningPrice;
    private final Integer matchCount;

    public MatchCount(LottoWinningPrice lottoWinningPrice, Integer matchCount) {
        this.lottoWinningPrice = lottoWinningPrice;
        this.matchCount = matchCount;
    }

    public MatchCount addToMatchCount() {
        return new MatchCount(lottoWinningPrice, matchCount + 1);
    }

    public Long mulMatchCountAndPrice() {
        return lottoWinningPrice.price * matchCount;
    }

    public static Map<LottoWinningPrice, MatchCount> initMatchCountCache() {

        Map<LottoWinningPrice, MatchCount> matchCountMap = new HashMap<>();

        for (LottoWinningPrice lottoWinningPrice : LottoWinningPrice.values()) {
            initLottoWinningPriceExceptNone(matchCountMap, lottoWinningPrice);
        }
        return matchCountMap;
    }

    private static void initLottoWinningPriceExceptNone(Map<LottoWinningPrice, MatchCount> matchCountMap, LottoWinningPrice lottoWinningPrice) {
        if (lottoWinningPrice != LottoWinningPrice.NONE) {
            MatchCount matchCount = new MatchCount(lottoWinningPrice, 0);
            matchCountMap.put(lottoWinningPrice, matchCount);
        }
    }

    public LottoWinningPrice getLottoWinningPrice() {
        return lottoWinningPrice;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    @Override
    public int compareTo(MatchCount that) {
        return Long.compare(this.lottoWinningPrice.price, that.lottoWinningPrice.price);
    }

    @Override
    public String toString() {
        return Integer.toString(matchCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchCount that = (MatchCount) o;
        return lottoWinningPrice == that.lottoWinningPrice && Objects.equals(matchCount, that.matchCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoWinningPrice, matchCount);
    }

    enum LottoWinningPrice {

        MATCH_3_COUNT(3, 5000L, "3개 일치 (5000원)- ", Boolean.FALSE),
        MATCH_4_COUNT(4, 50_000L, "4개 일치 (50000원)- ", Boolean.FALSE),
        MATCH_5_COUNT(5, 1_500_000L, "5개 일치 (1500000원)- ", Boolean.FALSE),
        MATCH_5_BONUS_COUNT(5, 30_000_000L, "5개 일치, 보너스 볼 일치(30000000원)- ", Boolean.TRUE),
        MATCH_6_COUNT(6, 2_000_000_000L, "6개 일치 (2000000000원)- ", Boolean.FALSE),
        NONE(Integer.MIN_VALUE, Long.MIN_VALUE, "", Boolean.FALSE);

        private final Integer matchCount;
        private final Long price;
        private final String description;
        private final Boolean includeBonusBall;

        LottoWinningPrice(Integer matchCount, Long price, String description, Boolean includeBonusBall) {
            this.matchCount = matchCount;
            this.price = price;
            this.description = description;
            this.includeBonusBall = includeBonusBall;
        }

        public static LottoWinningPrice winningPrice(Integer matchCount, Boolean bonusBallContains) {

            return Arrays.stream(LottoWinningPrice.values())
                    .filter(i -> i.matchCount.equals(matchCount))
                    .filter(i -> i.includeBonusBall.equals(bonusBallContains))
                    .findFirst()
                    .orElse(NONE);
        }

        @Override
        public String toString() {
            return description;
        }
    }
}
