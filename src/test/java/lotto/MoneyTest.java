package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @ParameterizedTest
    @CsvSource(value = {"1000:1000", "2000:2000", "3000:3000"}, delimiter = ':')
    public void 금액_Int_저장_확인(String input, int Expected) {
        Money money = new Money(input);
        assertThat(money.getMoney()).isEqualTo(Expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2000:1000:1000", "4000:2000:2000", "6000:3000:3000"}, delimiter = ':')
    public void 금액_차감_기능_확인(String input, String subtract, int Expected) {
        // given
        Money money = new Money(input);
        // when
        money.substractMoney(subtract);
        // then
        assertThat(money.getMoney()).isEqualTo(Expected);
    }
}
