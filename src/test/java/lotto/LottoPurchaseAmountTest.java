package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 구매 금액")
class LottoPurchaseAmountTest {

    @DisplayName("숫자만 입력 가능하다.")
    @ParameterizedTest
    @ValueSource(strings = {"s"})
    public void number(String number) {
        assertThatThrownBy(() -> new LottoPurchaseAmount(number))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("숫자만 입력 가능합니다.");
    }

    @DisplayName("1000의 배수만 입력 가능하다")
    @ParameterizedTest
    @ValueSource(strings = {"1001", "10"})
    public void multiple(String number) {
        assertThatThrownBy(() -> new LottoPurchaseAmount(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000의 배수만 입력가능합니다.");
    }
}
