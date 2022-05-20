package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("수량에 대한 테스트")
class QuantityTest {

    @DisplayName("숫자값이 들어오면 정상적으로 반환된다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void manual_test(int input) {
        Quantity quantity = new Quantity(String.valueOf(input));
        assertThat(quantity.getQuantity()).isEqualTo(input);
    }

    @DisplayName("숫자 이외의 값이 들어오면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "asdasd", "?"})
    void manual_test(String input) {
        assertThatThrownBy(() -> {
            new Quantity(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.INVALID_NUMBER_FORMAT.getMessage());
    }
}
