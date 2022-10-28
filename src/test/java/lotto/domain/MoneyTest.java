package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @DisplayName("1000원 이상의 수를 입력하면 Money 를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 5000, 10000})
    void money(int price) {

        assertThat(new Money(price)).isInstanceOf(Money.class);
    }

    @DisplayName("1000원 이하의 수가 입력되면 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 999, -1000})
    void money_fail(int price) {

        assertThatThrownBy(() -> new Money(price)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 금액 / 1000 개의 로또를 구매할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "5000:5", "10000:10"}, delimiter = ':')
    void money_count(int price, int expect) {

        assertThat(new Money(price).availableLottoSize()).isEqualTo(expect);
    }
}
