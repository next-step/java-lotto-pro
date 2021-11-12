package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EarningRateTest {
    @DisplayName("수익률 생성")
    @Test
    void constructEarningRate() {
        assertThat(new EarningRate(BigDecimal.valueOf(0.5))).isEqualTo(new EarningRate(BigDecimal.valueOf(0.5)));
    }
}
