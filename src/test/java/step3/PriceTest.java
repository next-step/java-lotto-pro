package step3;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Price;

@DisplayName("Price 클래스")
public class PriceTest {
    @DisplayName("입력한 금액이 0 혹은 음수면 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -15000, -12000, -8000})
    void priceIsMinusThenIllegalArgumentException(final int inputPrice) {
        assertThatThrownBy(() -> new Price(inputPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 금액이 천단위로 나누어 떨어지지 않으면 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {18200, 13250, 1100, 3200})
    void priceIsNotDivisibleThenIllegalArgumentException(final int inputPrice) {
        assertThatThrownBy(() -> new Price(inputPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
