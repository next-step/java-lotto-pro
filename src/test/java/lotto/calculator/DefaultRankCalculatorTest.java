package lotto.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.domain.Rank;
import lotto.domain.calculator.impl.DefaultRankCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("기본 랭크 계산기 테스트")
class DefaultRankCalculatorTest {

    @DisplayName("계산기는 싱글턴 객체로 구현되어야 한다")
    @Test
    void singleton_test() {
        DefaultRankCalculator defaultRankCalculator = DefaultRankCalculator.getInstance();
        DefaultRankCalculator defaultRankCalculator_2 = DefaultRankCalculator.getInstance();
        DefaultRankCalculator defaultRankCalculator_3 = DefaultRankCalculator.getInstance();

        assertEquals(defaultRankCalculator, defaultRankCalculator_2);
        assertEquals(defaultRankCalculator, defaultRankCalculator_3);
        assertEquals(defaultRankCalculator_2, defaultRankCalculator_3);
    }

    @DisplayName("기본 랭크 계산기는 숫자5개를 전달하면 3등으로 판단한다")
    @Test
    void default_calculator_test() {
        DefaultRankCalculator defaultRankCalculator = DefaultRankCalculator.getInstance();

        Rank rank = defaultRankCalculator.calculator(5);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("기본 랭크 계산기는 맞춘 숫자를 전달하면 기본 enum 과 매칭되어 계산되어야 한다")
    @Test
    void default_calculator_test2() {
        DefaultRankCalculator defaultRankCalculator = DefaultRankCalculator.getInstance();

        int given = 3;
        Rank rank = defaultRankCalculator.calculator(given);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }
}
