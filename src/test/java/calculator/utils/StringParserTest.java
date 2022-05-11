package calculator.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringParserTest {
    @Test
    @DisplayName("양의 정수를 가진 문자열이 숫자로 파싱되어야 한다")
    void parse_as_integer() {
        String string = "2";
        Integer parsed = StringParser.parseAsInteger(string);

        assertThat(parsed).isEqualTo(2);
    }

    @Test
    @DisplayName("음의 정수를 가진 문자열은 오류가 반환되어야 한다")
    void parse_but_error_on_negative_value() {
        String string = "-2";

        assertThatThrownBy(() -> StringParser.parseAsInteger(string))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("숫자가 아닌 문자열은 오류가 반환되어야 한다")
    void parse_but_error_on_non_number_value() {
        String string = "가";

        assertThatThrownBy(() -> StringParser.parseAsInteger(string))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("[ERROR]");
    }
}
