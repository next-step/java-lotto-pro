package study.lotto.domain.draw;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DivisionRuleTest {
    private DivisionRule divisionRule;

    @BeforeEach
    void setUp() {
        divisionRule = new DivisionRule();
        divisionRule.add(Division.DIVISION_ONE, false);
        divisionRule.add(Division.DIVISION_TWO, true);
        divisionRule.add(Division.DIVISION_THREE, false);
        divisionRule.add(Division.DIVISION_FOUR, true);
        divisionRule.add(Division.DIVISION_FOUR, true);
        divisionRule.add(Division.DIVISION_FIVE, false);
        divisionRule.add(Division.DIVISION_FIVE, false);
    }

    @Test
    @DisplayName("등수 규칙을 저장하면 저장된 규칙의 총 개수를 확인할 수 있다.")
    void 등수_규칙_저장() {
        assertThat(divisionRule.hasSize()).isEqualTo(7);
    }

    @Test
    @DisplayName("저장된 규칙에서 입력된 조건에 해당하는 등수를 확인할 수 있다.")
    void 등수_확인() {
        assertThat(divisionRule.check(5, true)).isEqualTo(Division.DIVISION_TWO);
    }
}
