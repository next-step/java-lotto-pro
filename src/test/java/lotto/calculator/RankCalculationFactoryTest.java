package lotto.calculator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import lotto.domain.calculator.RankCalculationFactory;
import lotto.domain.calculator.RankCalculator;
import lotto.domain.calculator.impl.BonusRankCalculator;
import lotto.domain.calculator.impl.DefaultRankCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("랭크 계산기 팩토리 테스트")
class RankCalculationFactoryTest {

    @DisplayName("팩토리가 보너스 계산기를 응답하면 정상적으로 반환되어야 한다")
    @Test
    void factory_test() {
        Lotto lotto = mock(Lotto.class);
        WinningNumbers winningNumbers = mock(WinningNumbers.class);

        when(winningNumbers.isContainsBonusNumber(lotto))
            .thenReturn(true);

        RankCalculator calculator = RankCalculationFactory.getRankCalculator(lotto, winningNumbers);

        assertTrue(calculator instanceof BonusRankCalculator);
    }

    @DisplayName("팩토리가 기본 계산기를 응답하면 정상적으로 반환되어야 한다")
    @Test
    void factory_test2() {
        Lotto lotto = mock(Lotto.class);
        WinningNumbers winningNumbers = mock(WinningNumbers.class);

        when(winningNumbers.isContainsBonusNumber(lotto))
            .thenReturn(false);

        RankCalculator calculator = RankCalculationFactory.getRankCalculator(lotto, winningNumbers);

        assertTrue(calculator instanceof DefaultRankCalculator);
    }
}
