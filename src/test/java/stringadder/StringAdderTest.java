package stringadder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.ParameterizedTest.DISPLAY_NAME_PLACEHOLDER;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

/**
 * 기능 요구사항
 * <p>
 * - 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” =>
 * 6)
 * <p>
 * - 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어
 * “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
 * <p>
 * - 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.
 */
public class StringAdderTest {
    private final StringAdder adder = new StringAdder();

    @DisplayName("null 혹은 빈 문자열은 0을 반환한다.")
    @ParameterizedTest(name = DISPLAY_NAME_PLACEHOLDER)
    @NullAndEmptySource
    void nullOrEmpty(final String value) {
        assertThat(adder.calculate(value)).isZero();
    }

    @ParameterizedTest(name = "[{0}]을 넣으면 [{1}]을 반환한다.")
    @CsvSource({
            "1, 1",
            "0, 0",
            "3, 3"
    })
    void singleNumber(final String value, final int expected) {
        assertThat(adder.calculate(value)).isEqualTo(expected);
    }

    @DisplayName("숫자 사이에 콤마(,)나 콜론(:)으로 구분하면 합을 반환한다.")
    @ParameterizedTest(name = DISPLAY_NAME_PLACEHOLDER + " [{0}] = [{1}] ")
    @CsvSource(value = {
            "'1,2'=3",
            "'1,2,3'=6",
            "'1:2,3'=6"
    }, delimiter = '=')
    void multipleNumbers(final String value, final int expected) {
        assertThat(adder.calculate(value)).isEqualTo(expected);
    }

    @DisplayName("//과 \\n 사이에 커스텀 구분자를 넣으면, 커스텀 구분자로 숫자를 구분한다.")
    @Test
    void customDelimiter() {
        assertThat(adder.calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @DisplayName("음수를 입력할 수 없다.")
    @Test
    void negative() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> adder.calculate("-1"))
                .withMessageStartingWith("음수가 아니어야 합니다.");
    }

    @DisplayName("숫자가 아닌 값을 입력할 수 없다.")
    @Test
    void illegalToken() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> adder.calculate("&,9"))
                .withMessage("정수여야 합니다. value=[&]");
    }
}
