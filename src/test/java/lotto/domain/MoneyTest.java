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

        assertThat(Money.from(price)).isInstanceOf(Money.class);
    }

    @DisplayName("1000원 이하의 수가 입력되면 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 999, -1000})
    void money_fail(int price) {

        assertThatThrownBy(() -> Money.from(price)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 금액 / 1000 개의 로또를 구매할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "5000:5", "10000:10"}, delimiter = ':')
    void money_count(int price, int expect) {

        assertThat(Money.from(price).availableLottoSize()).isEqualTo(expect);
    }

    @DisplayName("갯수 입력을 통해 금액을 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 10, 100, 9999})
    void money_from(int count) {

        assertThat(Money.fromCount(count)).isInstanceOf(Money.class);
    }


    @DisplayName("입력한 갯수가 음수이면 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -10, -100, -999})
    void money_from_error(int count) {

        assertThatThrownBy(() -> Money.fromCount(count)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액의 뺄셈 연산이 가능하다.")
    @ParameterizedTest
    @CsvSource(value = {"2000:1000:1000", "30000:20000:10000", "15000:3000:12000"}, delimiter = ':')
    void minus(int from, int to, int expect) {

        Money fromMoney = Money.from(from);
        Money toMoney = Money.from(to);
        Money expectMoney = Money.from(expect);

        Money actual = fromMoney.minus(toMoney);

        assertThat(actual).isEqualTo(expectMoney);
    }

    @DisplayName("가지고 있는 금액대비 구매 가능한 수이면 true 이다.")
    @ParameterizedTest
    @CsvSource(value = {"2000:2", "2000:1", "2000:0"}, delimiter = ':')
    void possible_lotto_count(int money, int count) {

        Money fromMoney = Money.from(money);

        assertThat(fromMoney.isPossibleLottoCount(count)).isTrue();
    }

    @DisplayName("가지고 있는 금액대비 구매 가능한 수이면 false 이다.")
    @ParameterizedTest
    @CsvSource(value = {"2000:3", "2000:4", "2000:5"}, delimiter = ':')
    void possible_lotto_count_false(int money, int count) {

        Money fromMoney = Money.from(money);

        assertThat(fromMoney.isPossibleLottoCount(count)).isFalse();
    }

}
