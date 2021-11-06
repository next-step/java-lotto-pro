package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EarningRateTest {
    @DisplayName("수익률 생성 테스트")
    @Test
    void constructEarningRate_success() {
        assertThat(new EarningRate(0.5)).isEqualTo(new EarningRate(0.5));
    }
}
