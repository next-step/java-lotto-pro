package step2;

import static org.assertj.core.api.Assertions.*;

import java.util.regex.Matcher;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("StringAddCalculator.splitAndSum 의 null 또는 빈문자 입력시 0 리턴")
    public void splitAndSum_null_또는_빈문자(String input) {
        // given, when
        int result = StringAddCalculator.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("문자 길이 1일때 그대로 반환, \"1\" 문자열 입력시 1을 반환")
    public void splitAndSum_숫자하나() {
        // given, when
        int result = StringAddCalculator.splitAndSum("1");

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("콤마로 구분된 숫자 문자 (1,2) 입력 결과 3 검증")
    public void splitAndSum_쉼표구분자() throws Exception {
        // given, when
        int result = StringAddCalculator.splitAndSum("1,2");

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("콤마,콜론 혼용 문자 (1,2:3:3) 입력 결과 9 검증")
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        // given, when
        int result = StringAddCalculator.splitAndSum("1,2:3:3");

        // then
        assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("커스텀 구분자 (//A\n1A2A3A3) 입력 결과 9 검증")
    public void splitAndSum_custom_구분자() throws Exception {
        // given, when
        int result = StringAddCalculator.splitAndSum("//A\n1A2A3A3");

        // then
        assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("음수 입력 시 RuntimeException 발생")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("계산에 문자 입력 시 RuntimeException 발생")
    public void splitAndSum_string_sum_exception() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("a,2,3"))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("기본 구분자로 숫자 문자열 반환 검증")
    public void splitDelimiter_쉼표구분자() {
        // given
        String input = "10,20,30";

        // when
        String[] result = StringAddCalculator.splitDelimiterOfDefault(input);

        // then
        assertThat(result).contains("10", "20", "30");
    }

    @Test
    @DisplayName("기본 구분자 숫자 또는 콜론 String[] 반환 검증")
    public void splitDelimiter_쉼표_또는_콜론구분자() {
        // given
        String input = "10,20:30:40";

        // when
        String[] result = StringAddCalculator.splitDelimiterOfDefault(input);

        // then
        assertThat(result).contains("10", "20", "30", "40");
    }

    @Test
    @DisplayName("커스텀 구분자 String[] 반환 검증")
    public void splitDelimiter_커스텀구분자() {
        // given
        String input = "//;\n1;2;3";
        Matcher matcher = StringAddCalculator.CUSTOM_DELIMITER_REGEX.matcher(input);
        String[] result = {};

        // when
        if (matcher.find()) {
            result = StringAddCalculator.splitDelimiterOfCustom(matcher);
        }

        // then
        assertThat(result).contains("1", "2", "3");
    }

    @Test
    @DisplayName("stringSplit 기본 구분자 입력 반환 검증")
    public void stringSplit_기본_구분자() {
        // given
        String input = "10,20:30:40";

        // when
        String[] result = StringAddCalculator.stringSplit(input);

        // then
        assertThat(result).contains("10", "20", "30", "40");
    }

    @Test
    @DisplayName("stringSplit 커스텀 구분자 입력 반환 검증")
    public void stringSplit_커스텀_구분자() {
        // given
        String input = "//;\n1;2;3";

        // when
        String[] result = StringAddCalculator.stringSplit(input);

        // then
        assertThat(result).contains("1", "2", "3");
    }

}
