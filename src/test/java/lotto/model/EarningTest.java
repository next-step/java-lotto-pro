package lotto.model;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class EarningTest {

    @Test
    @DisplayName("Earning 생성 시 수익률 계산을 확인한다.")
    void Earning_수익률() {
        Prize totalPrize = Prize.of(5000);
        Money purchaseAmount = Money.of(14000);

        Earning earningRate = Earning.of(totalPrize, purchaseAmount);
        assertThat(earningRate.getEarningRate())
                .isCloseTo(BigDecimal.valueOf(0.35), Percentage.withPercentage(100));
    }
    
}
