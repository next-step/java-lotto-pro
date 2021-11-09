package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @DisplayName("상금과 구입 금액으로 수익률을 계산")
    @ParameterizedTest
    @CsvSource(value = {"5000:14000:0.35", "50000:50000:1.0", "100000:50000:2.0"}, delimiter = ':')
    void calculateYield(int prize, int pay, double result) {
        Money totalWinningMoney = new Money(prize);
        Money paidMoney = new Money(pay);
        assertThat(totalWinningMoney.calculateYield(paidMoney)).isEqualTo(result);
    }
}
