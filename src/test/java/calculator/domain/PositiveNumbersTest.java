package calculator.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.constant.ErrorCode;
import org.junit.jupiter.api.Test;

public class PositiveNumbersTest {

    @Test
    void 양의_정수_덧셈_시_INT_양의_범위_넘어가면_에러_발생() {
        String[] textNumbers = {"2147483645", "123"};
        PositiveNumbers positiveNumbers = new PositiveNumbers(textNumbers);
        assertThatThrownBy(() -> positiveNumbers.sumAll()).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.덧셈_결과_INT_양의_범위_넘김.getErrorMessage());
    }
}
