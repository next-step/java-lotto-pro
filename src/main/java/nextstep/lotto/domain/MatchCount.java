package nextstep.lotto.domain;

import java.util.Arrays;

import static nextstep.lotto.constance.LottoDisplayMessage.MATCH_COUNT_MIDDLE_MESSAGE;
import static nextstep.lotto.constance.LottoDisplayMessage.MATCH_COUNT_POSTFIX_MESSAGE;
import static nextstep.lotto.constance.LottoDisplayMessage.MATCH_COUNT_PREFIX_MESSAGE;

public class MatchCount implements Comparable<MatchCount> {

    private final Integer index;
    private final LottoWinningPrice lottoWinningPrice;
    private final Integer matchCount;

    public MatchCount(Integer index, Integer matchCount) {
        this.index = index;
        this.lottoWinningPrice = LottoWinningPrice.winningPrice(index);
        this.matchCount = matchCount;
    }

    public MatchCount addToMatchCount() {
        return new MatchCount(index, matchCount + 1);
    }

    public Long mulMatchCountAndPrice() {
        return lottoWinningPrice.price * matchCount;
    }

    @Override
    public int compareTo(MatchCount that) {
        return this.index - that.index;
    }

    @Override
    public String toString() {
        return index +
                MATCH_COUNT_PREFIX_MESSAGE +
                lottoWinningPrice.price +
                MATCH_COUNT_MIDDLE_MESSAGE +
                matchCount +
                MATCH_COUNT_POSTFIX_MESSAGE;
    }

    enum LottoWinningPrice {

        MATCH_3_COUNT(3, 5000L),
        MATCH_4_COUNT(4, 50_000L),
        MATCH_5_COUNT(5, 1_500_000L),
        MATCH_6_COUNT(6, 2_000_000_000L),
        NONE(Integer.MIN_VALUE, Long.MIN_VALUE);

        private final Integer index;
        private final Long price;

        LottoWinningPrice(Integer index, Long price) {
            this.index = index;
            this.price = price;
        }

        public static LottoWinningPrice winningPrice(Integer index) {
            return Arrays.stream(LottoWinningPrice.values())
                    .filter(i -> i.index.equals(index))
                    .findFirst()
                    .orElse(NONE);
        }
    }
}
