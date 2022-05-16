package study.lotto.domain.draw;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DivisionResultsTest {
    private DivisionResults divisionResults;

    @BeforeEach
    void setUp() {
        List<DivisionResult> divisionResultsList = Arrays.asList(
                new DivisionResult(Division.DIVISION_ONE, 0L),
                new DivisionResult(Division.DIVISION_TWO, 0L),
                new DivisionResult(Division.DIVISION_THREE, 1L),
                new DivisionResult(Division.DIVISION_FOUR, 0L),
                new DivisionResult(Division.DIVISION_FIVE, 4L));

        divisionResults = new DivisionResults(divisionResultsList);
    }

    @Test
    @DisplayName("전체 당첨금액 합계를 구한다.")
    void 전체_당첨금액_반환() {
        assertThat(divisionResults.totalPrize()).isEqualTo(new BigDecimal(1_520_000));
    }
}
