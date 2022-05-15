package lotto.util;

import lotto.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringToIntegerParserTest {
    @DisplayName("문자열로 된 숫자 값 Integer 변환")
    @Test
    void test_string_to_integer() {
        //given
        String numberStr = "1";
        //when & then
        assertThat(StringToIntegerParser.parseInt(numberStr)).isEqualTo(1);
    }

    @DisplayName("문자열이 숫자가 아닌 경우 예외 발생")
    @Test
    void test_string_not_integer() {
        //given
        String numberStr = "일";

        //when & then
        assertThatThrownBy(() -> StringToIntegerParser.parseInt(numberStr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMBER_FORMAT);
    }
}