package study.lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.lotto.model.exception.NotEnoughMoneyException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

class MoneyTest {


    @ParameterizedTest(name = "[{index}] 1000이상인 {0}로 머니를 생성할 수 있다.")
    @ValueSource(ints = {1000, 1001, 22000})
    void 금액1000원이상으로_머니를_생성할_수있다(int money) {
        assertThatNoException()
                .isThrownBy(() -> Money.valueOf(money));
    }


    @ParameterizedTest(name = "[{index}] 1000미만인 {0}로 머니를 생성할 수 있다.")
    @ValueSource(ints = {0, -112, 999})
    void 금액1000이만으로_머니를_생성하면_예외가_발생한다(int money) {
        assertThatExceptionOfType(NotEnoughMoneyException.class)
                .isThrownBy(() -> Money.valueOf(money))
                .withMessageMatching("최소 1000 이상의 값이어야 합니다.");
    }
}