package study.lotto.domain.lottomachine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PriceTest {
    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(strings = {"asdb", "1.6"})
    @DisplayName("정수가 아닌 값을 입력 받으면 예외를 발생 시킨다.")
    void 숫자외_입력시_예외처리(String input) {
        assertThatThrownBy(() -> new Price(input)).isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(strings = {"0", "-1"})
    @DisplayName("가격이 0보다 작거나 같으면 예외를 발생 시킨다.")
    void 음수_예외처리(String input) {
        assertThatThrownBy(() -> new Price(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("가격끼리 나눗셈이 가능하며 몫만 int로 반환한다.")
    void 나누기() {
        Price dividend = new Price("361");
        Price divisor = new Price("5");

        assertThat(dividend.divide(divisor)).isEqualTo(72);
    }

    @Test
    @DisplayName("가격과 int값은 곱할 수 있고 결과는 BigDecimal로 반환한다.")
    void 곱하기() {
        Price price = new Price("1000");
        int number = 5;

        assertThat(price.multiply(number)).isEqualTo(new BigDecimal(5000));
    }
}
