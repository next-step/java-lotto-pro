package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class EarningsRateTest {

    @DisplayName("총당첨금과 구매금액 정보를 입력 받는다.")
    @Test
    void createTest() {
        assertThat(new EarningsRate(5000, 14000))
                .isEqualTo(new EarningsRate(5000, 14000));
    }
}
