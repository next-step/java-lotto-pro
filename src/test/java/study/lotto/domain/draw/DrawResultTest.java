package study.lotto.domain.draw;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DrawResultTest {
    private DrawResult drawResult;

    @BeforeEach
    void setUp() {
        DivisionResults divisionResults = new DivisionResults(generateFeatures());
        drawResult = new DrawResult(divisionResults);
    }

    @Test
    @DisplayName("로또 구입 금액대비 수익률을 계산한다.")
    void 수익률_계산() {
        assertThat(drawResult.earningsRate(BigDecimal.valueOf(14000))).isEqualTo(BigDecimal.valueOf(0.35));
    }

    private List<DivisionResult> generateFeatures() {
        return Arrays.asList(
                new DivisionResult(Division.DIVISION_FIVE, 1L),
                new DivisionResult(Division.DIVISION_FOUR, 0L),
                new DivisionResult(Division.DIVISION_THREE, 0L),
                new DivisionResult(Division.DIVISION_TWO, 0L),
                new DivisionResult(Division.DIVISION_ONE, 0L));
    }
}
