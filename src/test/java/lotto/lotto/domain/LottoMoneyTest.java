package lotto.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 구매 금액")
class LottoMoneyTest {

    @DisplayName("1000의 배수만 입력 가능하다")
    @ParameterizedTest
    @ValueSource(ints = {1001, 10})
    public void multiple(int number) {
        assertThatThrownBy(() -> new LottoMoney(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000의 배수만 입력가능합니다.");
    }

    @DisplayName("로또 구매 금액을 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1000})
    public void constructor(int number) {
        assertThatNoException().isThrownBy(() -> new LottoMoney(number));
    }

    @DisplayName("로또 구매 횟수를 계산한다.")
    @ParameterizedTest
    @CsvSource(value = {"3000:3", "7000:7"}, delimiter = ':')
    public void constructor(int money, int expect) {
        assertThat(new LottoMoney(money).purchaseCount()).isEqualTo(expect);
    }
}
