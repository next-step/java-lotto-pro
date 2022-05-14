package lotto.view.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.view.constants.LottoConstant.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @ParameterizedTest
    @DisplayName("생성자 파라미터(구매금액)로 음수가 들어올 경우 IllegalArgumentException 예외를 발생시킨다.")
    @ValueSource(ints = {-1000, -2000, -3000})
    void Money_구매금액_음수(int input) {
        assertThatThrownBy(() -> Money.of(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매금액은 음수일 수 없습니다! : [%s]", input);
    }

    @ParameterizedTest
    @DisplayName("생성자 파라미터(구매금액)의 단위가 올바르지 않을 경우 IllegalArgumentException 예외를 발생시킨다.")
    @ValueSource(ints = {1500, 300, 12700})
    void Money_구매금액_단위(int input) {
        assertThatThrownBy(() -> Money.of(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매금액은 %s원 단위만 가능합니다! : 입력금액 [%d]", LOTTO_PRICE, input);
    }

}