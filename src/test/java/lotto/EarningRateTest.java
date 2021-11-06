package lotto;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EarningRateTest {
    @DisplayName("수익률 생성 테스트")
    @Test
    void constructEarningRate_success() {
        assertThat(new EarningRate(BigDecimal.valueOf(0.5))).isEqualTo(new EarningRate(BigDecimal.valueOf(0.5)));
    }

    @Test
    void makePrintableMessage() {
        assertThat(new EarningRate(BigDecimal.valueOf(0.5)).makePrintableMessage()).isEqualTo("0.50");
    }
}
