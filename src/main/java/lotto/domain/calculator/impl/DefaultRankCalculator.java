package lotto.domain.calculator.impl;

import static lotto.constants.LottoConstants.SECOND_RANK_COUNT_OF_MATCH;

import lotto.domain.Rank;
import lotto.domain.calculator.RankCalculator;

public class DefaultRankCalculator implements RankCalculator {

    private DefaultRankCalculator() {

    }

    private static class LazyHolder {

        private static final DefaultRankCalculator instance = new DefaultRankCalculator();
    }

    public static DefaultRankCalculator getInstance() {
        return LazyHolder.instance;
    }

    @Override
    public Rank calculator(int countOfMatch) {
        if (countOfMatch == SECOND_RANK_COUNT_OF_MATCH) {
            return Rank.THIRD;
        }

        return getRankByCountOfMatch(countOfMatch);
    }
}
