package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveNumberTest {
    @DisplayName("양수 문자열로 초기화하면 입력받은 양수 인자를 갖는다.")
    @ParameterizedTest(name = "양수 문자열 {0}로 초기화하면 {1} 인자를 갖는다.")
    @CsvSource(value = {"12:12", "4:4", "3:3"}, delimiter = ':')
    void parseNotNegativeInt(String input, int expect) {
        PositiveNumber parseNumber = PositiveNumber.parseNotNegativeNumber(input);
        assertThat(parseNumber.getPositiveNumber()).isEqualTo(expect);
    }

    @DisplayName("음수를 문자열로 초기화하면 RuntimeException 예외가 발생한다.")
    @ParameterizedTest(name = "음수 {0}를 문자열로 초기화하면 RuntimeException 예외가 발생한다.")
    @ValueSource(strings = {"-1", "-3", "-5"})
    void parseNotNegativeInt_negative(String input) {
        assertThatThrownBy(() -> PositiveNumber.parseNotNegativeNumber(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수가 입력되었습니다. 0 이상 값을 입력해주세요.");
    }

    @DisplayName("숫자가 아닌 문자열로 초기화하면 RuntimeException 예외가 발생한다.")
    @ParameterizedTest(name = "숫자가 아닌 문자열 {0}로 초기화하면 RuntimeException 예외가 발생한다.")
    @ValueSource(strings = {"!", ":", "e", "rr"})
    void parseNotNegativeInt_number(String input) {
        assertThatThrownBy(() -> PositiveNumber.parseNotNegativeNumber(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자 이외의 값이 입력되었습니다. 숫자를 입력해주세요.");
    }
}
