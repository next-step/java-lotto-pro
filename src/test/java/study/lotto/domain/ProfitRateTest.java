package study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("수익률 계산 검증 테스트")
class ProfitRateTest {

    @ParameterizedTest
    @CsvSource(value = { "14:0.36", "15:0.33", "20:0.25", "30:0.17" }, delimiter = ':')
    void 수익률_계산_누적_당첨_금액_고정(int quantity, String expected) {
        ProfitRate profitRate = new ProfitRate(quantity);
        profitRate.calculate(5000);

        assertEquals(expected, profitRate.toString());
    }

    @ParameterizedTest
    @CsvSource(value = { "5000:0.36", "10000:0.71", "1510000:107.86", "2000000000:142857.14" }, delimiter = ':')
    void 수익률_계산_수량_고정(int totalAmount, String expected) {
        ProfitRate profitRate = new ProfitRate(14);
        profitRate.calculate(totalAmount);

        assertEquals(expected, profitRate.toString());
    }
}
