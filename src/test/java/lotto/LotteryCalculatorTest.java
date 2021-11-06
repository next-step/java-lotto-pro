package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryCalculatorTest {
    @DisplayName("로또 구입 금액을 입력하면 구입 금액에 해당하는 로또 티켓 수 구입")
    @ParameterizedTest
    @CsvSource(value = {"14000:14", "14900:14", "12200:12", "500:0"}, delimiter = ':')
    void calculateNumberOfLottoTicket(int money, int result) {
        int numberOfLottoTicket = LotteryCalculator.calculateTicket(money);
        assertThat(numberOfLottoTicket).isEqualTo(result);
    }

    @DisplayName("구입금액과 상금으로 수익률을 계산")
    @ParameterizedTest
    @CsvSource(value = {"5000:14000:0.35", "50000:50000:1.0", "100000:50000:2.0"}, delimiter = ':')
    void calculateRevenue(int totalWinningMoney, int paidMoney, double result) {
        assertThat(LotteryCalculator.calculateRevenue(totalWinningMoney, paidMoney)).isEqualTo(result);
    }
}
