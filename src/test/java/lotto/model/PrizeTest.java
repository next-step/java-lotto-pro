package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.enums.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizeTest {

    @ParameterizedTest
    @DisplayName("생성자에 음수가 입력되면 예외를 발생시킨다.")
    @ValueSource(ints = {-100000, -4000, -3000})
    void Prize_예외발생(int input) {
        assertThatThrownBy(() -> Prize.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨금액은 음수일 수 없습니다!");
    }

    @Test
    @DisplayName("덧셈 연산을 확인한다.")
    void Prize_덧셈() {
        Prize secondPrize = SECOND.getPrize();
        Prize thirdPrize = THIRD.getPrize();

        Prize testPrize = secondPrize.add(thirdPrize);
        assertThat(testPrize.getAmount())
                .isEqualTo(31_500_000);
    }

    @Test
    @DisplayName("곱셈 연산을 확인한다.")
    void Prize_곱셈() {
        Prize secondPrize = SECOND.getPrize();

        Prize testPrize = secondPrize.multiply(2);
        assertThat(testPrize.getAmount())
                .isEqualTo(60_000_000);
    }

}
