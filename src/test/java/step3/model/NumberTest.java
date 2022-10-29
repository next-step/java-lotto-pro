package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @ParameterizedTest
    @DisplayName("숫자의 범위는 1~45 사이가 아닌 경우 exception이 발생한다.")
    @ValueSource(ints = {0, 46})
    void number_range_exception_test(int number) {
        assertThatThrownBy(() ->
            new Number(number)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
