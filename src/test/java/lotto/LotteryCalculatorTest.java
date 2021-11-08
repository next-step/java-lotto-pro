package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryCalculatorTest {
    @DisplayName("로또 구입 금액을 입력하면 구입 금액에 해당하는 로또 티켓 수 구입")
    @ParameterizedTest
    @CsvSource(value = {"14000:14", "14900:14", "12200:12", "500:0"}, delimiter = ':')
    void calculateTicket(int money, int result) {
        int numberOfLottoTicket = LotteryCalculator.calculateTicket(new Money(money));
        assertThat(numberOfLottoTicket).isEqualTo(result);
    }
}
