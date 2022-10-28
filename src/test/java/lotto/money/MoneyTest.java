package lotto.money;

import lotto.model.money.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyTest {

    private final Money money = Money.from(1000);

    @ParameterizedTest
    @CsvSource(value = {"1:1000", "11:90.9", "30:33.33"}, delimiter = ':')
    @DisplayName("Money의 divide한 값을 확인한다. (소수 3째자리에서 버림)")
    void moneyDivide(double input, double expected) {
        double result = money.divide(Money.from(input));
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1000", "5:5000", "30:30000"}, delimiter = ':')
    @DisplayName("Money의 multiply한 값을 확인한다.")
    void moneyMultiply(double input, double expected) {
        Money result = money.multiply(input);
        Assertions.assertThat(result).isEqualTo(Money.from(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"20:1020", "2000:3000", "10000:11000"}, delimiter = ':')
    @DisplayName("Money의 add한 값을 확인한다.")
    void moneyAdd(double input, double expected) {
        Money result = money.add(Money.from(input));
        Assertions.assertThat(result).isEqualTo(Money.from(expected));
    }
}
