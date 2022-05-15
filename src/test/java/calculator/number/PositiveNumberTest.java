package calculator.number;

import calculator.common.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveNumberTest {
    @DisplayName("음수가 아닌 숫자 입력")
    @Test
    void test_matches_positive_number() {
        //given
        String numberStr = "0";

        //when
        PositiveNumber positiveNumber = new PositiveNumber(numberStr);

        //then
        assertThat(positiveNumber.parseNumber()).isEqualTo(0);
    }

    @DisplayName("음수 입력 시 예외 처리")
    @Test
    void test_negative_number_exception() {
        //given
        String numberStr = "-1";

        //when & then
        assertThatThrownBy(() -> new PositiveNumber(numberStr))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.NOT_POSITIVE_NUMBER);
    }

    @DisplayName("숫자가 아닌 값 입력 시 예외 처리")
    @Test
    void test_not_number_exception() {
        //given
        String numberStr = "일";

        //when & then
        assertThatThrownBy(() -> new PositiveNumber(numberStr))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.NOT_POSITIVE_NUMBER);
    }
}