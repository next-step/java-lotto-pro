package study.lotto.domain.draw;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DivisionResultTest {
    private DivisionResult divisionResult;

    @BeforeEach
    void setUp() {
        divisionResult = new DivisionResult(Division.DIVISION_THREE, 3L);
    }

    @Test
    @DisplayName("해당 등수의 상금 합계를 구한다.")
    void 상금_계산() {
        assertThat(divisionResult.calculatePrize()).isEqualTo(new BigDecimal(150000));
    }

    @Test
    @DisplayName("입력한 등수와 같은 등수인지 확인한다.")
    void 등수_확인_성공() {
        assertThat(divisionResult.isDivisionSame(Division.DIVISION_THREE)).isTrue();
    }

    @Test
    @DisplayName("입력한 등수와 다른지 확인한다.")
    void 등수_확인_실패() {
        assertThat(divisionResult.isDivisionSame(Division.DIVISION_ONE)).isFalse();
    }
}
