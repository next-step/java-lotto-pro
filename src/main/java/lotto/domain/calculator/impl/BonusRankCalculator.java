package lotto.domain.calculator.impl;

import static lotto.constants.LottoConstants.SECOND_RANK_COUNT_OF_MATCH;

import lotto.domain.Rank;
import lotto.domain.calculator.RankCalculator;

public class BonusRankCalculator implements RankCalculator {

    private BonusRankCalculator() {

    }

    private static class LazyHolder {

        private static final BonusRankCalculator instance = new BonusRankCalculator();
    }

    public static BonusRankCalculator getInstance() {
        return LazyHolder.instance;
    }

    @Override
    public Rank calculator(int countOfMatch) {
        if (countOfMatch == SECOND_RANK_COUNT_OF_MATCH) {
            return Rank.SECOND;
        }

        return getRankByCountOfMatch(countOfMatch);
    }
}
