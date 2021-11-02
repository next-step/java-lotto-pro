package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null 값으로 더하면 0을 반환한다.")
    public void splitAndSum1(String input) {
        // when
        int result = StringAddCalculator.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 한개의 문자열로 더하면 해당 숫자를 반환한다.")
    public void splitAndSum2() {
        // when
        int result = StringAddCalculator.splitAndSum("1");

        // then
        assertThat(result).isEqualTo(1);
    }

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @CsvSource(value = {"1,2:3", "1,2,3:6"}, delimiter = ':')
    @DisplayName("숫자를 컴마로 구분한 문자열로 더하면 숫자들의 합을 반환한다.")
    public void splitAndSum3(String input, int expected) {
        // when
        int result = StringAddCalculator.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("숫자를 컴마나 콜론으로 구분한 문자열로 더하면 숫자들의 합을 반환한다.")
    public void splitAndSum4() {
        // when
        int result = StringAddCalculator.splitAndSum("1,2:3");

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자를 커스텀 구분자로 구분한 문자열로 더하면 숫자들의 합을 반환한다.")
    public void splitAndSum5() {
        // when
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");

        // then
        assertThat(result).isEqualTo(6);
    }
}
