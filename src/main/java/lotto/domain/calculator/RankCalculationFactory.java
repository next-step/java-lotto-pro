package lotto.domain.calculator;

import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import lotto.domain.calculator.impl.BonusRankCalculator;
import lotto.domain.calculator.impl.DefaultRankCalculator;

public class RankCalculationFactory {

    public static RankCalculator getRankCalculator(Lotto lotto, WinningNumbers winningNumbers) {
        if (winningNumbers.isContainsBonusNumber(lotto)) {
            return BonusRankCalculator.getInstance();
        }

        return DefaultRankCalculator.getInstance();
    }
}
