package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeCalculatorTest {
    @Test
    @DisplayName("지불 금액과 상금 결과 Map이 입력되었을 때 올바른 수익률이 반환되어야 한다")
    void should_return_correct_return_of_ratio() {
        // given
        final int payment = 10000;
        final Map<Prize, Integer> prizeMap = new HashMap<>();
        prizeMap.put(Prize.THREE_MATCHES, 1);
        prizeMap.put(Prize.FOUR_MATCHES, 0);
        prizeMap.put(Prize.FIVE_MATCHES, 0);
        prizeMap.put(Prize.SIX_MATCHES, 0);

        // when
        final double returnOfRatio = PrizeCalculator.returnOfRatio(payment, prizeMap);

        // then
        assertThat(returnOfRatio).isEqualTo(0.5);
    }
}
