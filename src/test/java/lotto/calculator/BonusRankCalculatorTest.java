package lotto.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.domain.Rank;
import lotto.domain.calculator.impl.BonusRankCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("보너스 점수에 대한 랭크 계산기")
class BonusRankCalculatorTest {

    @DisplayName("계산기는 싱글턴 객체로 구현되어야 한다")
    @Test
    void singleton_test() {
        BonusRankCalculator bonusRankCalculator = BonusRankCalculator.getInstance();
        BonusRankCalculator bonusRankCalculator_2 = BonusRankCalculator.getInstance();
        BonusRankCalculator bonusRankCalculator_3 = BonusRankCalculator.getInstance();

        assertEquals(bonusRankCalculator, bonusRankCalculator_2);
        assertEquals(bonusRankCalculator, bonusRankCalculator_3);
        assertEquals(bonusRankCalculator_2, bonusRankCalculator_3);
    }

    @DisplayName("보너스 랭크 계산기는 숫자5개를 전달하면 2등으로 판단한다")
    @Test
    void bonus_calculator_test() {
        BonusRankCalculator bonusRankCalculator = BonusRankCalculator.getInstance();

        Rank rank = bonusRankCalculator.calculator(5);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}
