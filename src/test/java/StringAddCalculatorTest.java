import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @DisplayName("null, \"\" 이 들어오는 경우 0을 리턴하는지 확인")
    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String text) {
        int sum = StringAddCalculator.splitAndSum(text);
        assertThat(sum).isEqualTo(0);
    }

    @DisplayName("숫자 하나가 들어오는 경우 그대로 그 숫자를 리턴하는지 확인")
    @ParameterizedTest
    @CsvSource(value = { "1:1", "2:2", "3:3", "0:0" }, delimiterString = ":")
    public void splitAndSum_숫자하나(String text, int expected) {
        int sum = StringAddCalculator.splitAndSum(text);
        assertThat(sum).isEqualTo(expected);
    }

    @DisplayName(", 를 구분자로 나눈 문자열을 변환한 숫자의 합을 반환하는지 확인")
    @ParameterizedTest
    @CsvSource(value = { "1,2,3:6", "0,0,0:0" }, delimiterString = ":")
    public void splitAndSum_쉼표구분자(String text, int expected) {
        int sum = StringAddCalculator.splitAndSum(text);
        assertThat(sum).isEqualTo(expected);
    }

    @DisplayName(", 또는 : 를 구분자로 나눈 문자열을 변환한 숫자의 합을 반환하는지 확인")
    @ParameterizedTest
    @CsvSource(value = { "1,2:3/6", "0:0,0/0" }, delimiterString = "/")
    public void splitAndSum_쉼표_또는_콜론_구분자(String text, int expected) {
        int sum = StringAddCalculator.splitAndSum(text);
        assertThat(sum).isEqualTo(expected);
    }

    @DisplayName("정해진 포맷에 지정한 구분자로 나눈 문자열을 변환한 숫자의 합을 반환하는지 확인")
    @ParameterizedTest
    @CsvSource(value = { "//;\n1;1;1?3", "//*\n1*2*3?6" }, delimiterString = "?")
    public void splitAndSum_custom_구분자(String text, int expected) {
        int sum = StringAddCalculator.splitAndSum(text);
        assertThat(sum).isEqualTo(expected);
    }

    @DisplayName("구분자 사이에 음수가 나온 경우 RuntimeException 을 반환하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = { "-1,2,3", "0,1,-100" })
    public void splitAndSum_negative(String text) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(text)).isInstanceOf(RuntimeException.class);
    }
}
