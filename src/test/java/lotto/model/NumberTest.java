package lotto.model;

import static lotto.model.Number.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("로또의 숫자가 1~45 사이의 수가 아닐 경우 예외 발생")
    void 객체_생성_시_유효성_검사(int input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new Number(input)
        ).withMessage(NUMBER_RANGE_ERR_MSG);
    }

    @Test
    void equals() {
        assertThat(new Number(1)).isEqualTo(new Number(1));
    }

    @Test
    void compareTo() {
        assertThat(new Number(2)).isGreaterThan(new Number(1));
    }
}
