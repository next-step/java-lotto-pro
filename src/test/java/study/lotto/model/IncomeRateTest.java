package study.lotto.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IncomeRateTest {

    @Test
    void 수익과_로또복권을_구매한_비용을_통해서_수익률을_확인할_수_있다() {
        final IncomeRate incomeRate = IncomeRate.valueOf(BigDecimal.valueOf(5000), 14);
        assertEquals(incomeRate.getIncomeRate(), 0.35);
    }
}