package lotto.auto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @ParameterizedTest
    @CsvSource(value = {"1000:1000", "2000:2000", "3000:3000"}, delimiter = ':')
    public void 금액_Int_저장_확인(String input, int Expected) {
        Money money = new Money(input);
        assertThat(money.getMoney()).isEqualTo(Expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "10a0", "0dsaqwe"})
    public void 금액_문자열_예외_확인(String input) {
        assertThatThrownBy(() -> new Money().changeStringToInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
