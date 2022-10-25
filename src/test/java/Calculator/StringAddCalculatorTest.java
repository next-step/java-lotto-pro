package Calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAddCalculatorTest {

    @DisplayName("null 또는 빈 문자열을 입력하면 계산값은 0이다.")
    @ParameterizedTest()
    @NullSource
    @ValueSource(strings = {"", " ", "  "})
    public void splitAndSum_null_또는_빈문자(String text) {

        assertThat(StringAddCalculator.splitAndSum(text)).isZero();
    }

    @DisplayName("숫자 하나를 입력하면 계산된 결과는 입력된 숫자와 같다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "50", "300", "4000"})
    public void splitAndSum_숫자하나(String text) throws Exception {

        int expect = Integer.parseInt(text);

        assertThat(StringAddCalculator.splitAndSum(text)).isEqualTo(expect);

    }

    @DisplayName("쉼표를 구분자로 하여 값의 덧셈이 가능하다.")
    @ParameterizedTest(name = "{0}의 계산 결과는 {1}이다.")
    @CsvSource(value = {"1,2:3", "30,50:80", "300,700:1000"}, delimiter = ':')
    public void splitAndSum_쉼표구분자(String text, int expect) throws Exception {

        int result = StringAddCalculator.splitAndSum(text);

        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("쉼표 또는 콜론을 구분자로 하여 값의 덧셈이 가능하다.")
    @ParameterizedTest(name = "{0}의 계산 결과는 {1}이다.")
    @CsvSource(value = {"1,2:3?6", "30:50,80?160", "300,700:1000,1:2?2003"}, delimiter = '?')
    public void splitAndSum_쉼표_또는_콜론_구분자(String text, int expect) throws Exception {

        int result = StringAddCalculator.splitAndSum(text);

        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("임의의 구분자 지정이 가능하다.")
    @MethodSource("custom_delimiter_testcase")
    @ParameterizedTest
    public void splitAndSum_custom_구분자(String text, int expect) throws Exception {

        int result = StringAddCalculator.splitAndSum(text);

        assertThat(result).isEqualTo(expect);
    }

    private static Stream<Arguments> custom_delimiter_testcase() {
        return Stream.of(
                Arguments.of("//;\n1;2", 3),
                Arguments.of("//~\n1~2:3,4", 10),
                Arguments.of("//#\n1#2#3#4", 10)
        );
    }

    @DisplayName("숫자 이외의 값이나 음수가 들어오면 RuntimeException 이 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,a,3", "-1,2,3", "a,-3"})
    public void splitAndSum_negative(String text) throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(text))
                .isInstanceOf(RuntimeException.class);
    }
}
