package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = {-5, -100, -2345, -5000})
    @DisplayName("음수 금액 투입 시 IllegalArgumentException 발생")
    void 음수_금액_투입(int data) {
        assertThatThrownBy(() -> new Money(data)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 1500, 5300, 84360})
    @DisplayName("로또 가격으로 나누어지지 않는 금액 투입 시 IllegalArgumentException 발생")
    void 나누어지지_않는_금액_투입(int data) {
        assertThatThrownBy(() -> new Money(data)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "5000:5", "100000:100"}, delimiter = ':')
    @DisplayName("투입 금액에 대한 구매 가능 로또 수 반환")
    void 구매_가능한_로또수(int money, int expected) {
        assertThat(new Money(money).getBuyableLottoCount()).isEqualTo(expected);
    }
}
