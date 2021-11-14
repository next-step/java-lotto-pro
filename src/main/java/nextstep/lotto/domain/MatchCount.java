package nextstep.lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static nextstep.lotto.constance.LottoDisplayMessage.MATCH_COUNT_MIDDLE_MESSAGE;
import static nextstep.lotto.constance.LottoDisplayMessage.MATCH_COUNT_POSTFIX_MESSAGE;
import static nextstep.lotto.constance.LottoDisplayMessage.MATCH_COUNT_PREFIX_MESSAGE;

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

    @Override
    public int compareTo(MatchCount that) {
        return this.lottoWinningPrice.matchCount - that.lottoWinningPrice.matchCount;
    }

    @Override
    public String toString() {
        return lottoWinningPrice.matchCount +
                MATCH_COUNT_PREFIX_MESSAGE +
                lottoWinningPrice.price +
                MATCH_COUNT_MIDDLE_MESSAGE +
                matchCount +
                MATCH_COUNT_POSTFIX_MESSAGE;
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

        MATCH_3_COUNT(3, 5000L),
        MATCH_4_COUNT(4, 50_000L),
        MATCH_5_COUNT(5, 1_500_000L),
        MATCH_6_COUNT(6, 2_000_000_000L),
        NONE(Integer.MIN_VALUE, Long.MIN_VALUE);

        private final Integer matchCount;
        private final Long price;

        LottoWinningPrice(Integer matchCount, Long price) {
            this.matchCount = matchCount;
            this.price = price;
        }

        public static LottoWinningPrice winningPrice(Integer matchCount) {
            return Arrays.stream(LottoWinningPrice.values())
                    .filter(i -> i.matchCount.equals(matchCount))
                    .findFirst()
                    .orElse(NONE);
        }
    }
}
