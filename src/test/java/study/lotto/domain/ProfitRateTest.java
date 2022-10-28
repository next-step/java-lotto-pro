package study.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProfitRateTest {

    @Test
    void 수익률_계산() {
        ProfitRate profitRate = new ProfitRate(14);
        profitRate.calculate(5000);

        assertEquals("0.36", profitRate.toString());
    }
}
