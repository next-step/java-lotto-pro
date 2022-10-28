package lotto.money;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyTest {

    private final Money money = Money.from(1000);

    @ParameterizedTest
    @CsvSource(value = {"1:1000", "11:90.9", "30:33.33"}, delimiter = ':')
    @DisplayName("Money의 divide 한 값을 확인한다. (소수 3째자리에서 버림)")
    void moneyDivide(double input, double expected) {
        double result = money.divide(Money.from(input));
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Money의 divide 메소드에서 money.value가 0인 경우 IllegalArgumentException을 던진다.")
    void moneyDivideException() {
        Money zero = Money.from(0);

        Assertions.assertThatThrownBy(() -> money.divide(zero))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
