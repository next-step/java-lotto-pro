package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.enums.Grade;

class ProfitRateCalculatorTest {

    @Test
    @DisplayName("당첨 등급과 로또 구매액을 통해 수익률을 계산할 수 있다")
    void getProfitRate() {
        // given
        Grades grades = new Grades();
        grades.increaseGradeCount(Grade.FIRST);
        grades.increaseGradeCount(Grade.SECOND);
        int amount = 10000;

        // when
        Float result = ProfitRateCalculator.getProfitRate(grades, amount);

        // then
        float expectedRate = (float) (Grade.FIRST.getAmount() + Grade.SECOND.getAmount()) / amount;
        assertThat(result).isEqualTo(expectedRate);
    }

}