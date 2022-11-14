package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.domain.LottoMoney.LOTTO_MINIMUM_PRICE;
import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 구매 금액")
class LottoMoneyTest {

    @DisplayName("1000 이상만 입력 가능하다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 999})
    public void multiple(int number) {
        assertThatThrownBy(() -> new LottoMoney(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_MINIMUM_PRICE + "원이상부터 로또 번호 생성 가능합니다.");
    }

    @DisplayName("로또 구매 금액을 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1000})
    public void constructor(int number) {
        assertThatNoException().isThrownBy(() -> new LottoMoney(number));
    }

    @DisplayName("로또 구매 횟수를 계산한다.")
    @ParameterizedTest
    @CsvSource(value = {"3000:1:2", "2500:1:1", "7000:1:6"}, delimiter = ':')
    public void constructor(int money, int manualLottoCount, int expect) {
        assertThat(new LottoMoney(money).purchaseCount(manualLottoCount)).isEqualTo(expect);
    }
}
