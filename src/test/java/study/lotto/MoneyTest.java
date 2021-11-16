package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.lotto.domain.Money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static study.lotto.view.MessageUtil.MINIMUM_MONEY_INPUT_ERR_MSG;
import static study.lotto.view.MessageUtil.NEGATIVE_NUMBER_ERR_MSG;

class MoneyTest {

    @Test
    @DisplayName("음수입력시 예외가 발생해야한다.")
    void 음수입력_테스트() {
        assertThatThrownBy(() -> new Money("-1000"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(NEGATIVE_NUMBER_ERR_MSG);
    }

    @Test
    @DisplayName("1000 미만의 숫자 입력시 예외가 발생해야한다.")
    void 최소금액_테스트() {
        assertThatThrownBy(() -> new Money("999"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(MINIMUM_MONEY_INPUT_ERR_MSG);
    }

    @Test
    @DisplayName("숫자형태가 아닐시 예외가 발생해야 한다.")
    void 숫자형태_테스트() {
        assertThatThrownBy(() -> new Money("1000a"))
                .isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @DisplayName("구매갯수 테스트(1000원 미만의 금액은 무시한다)")
    @ValueSource(strings = {"14000", "14999"})
    void buyCountTest(String userInput) {
        Money money = new Money(userInput);
        assertThat(money.getPurchaseCount()).isEqualTo(14);
    }
}