package calculator.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author : choi-ys
 * @date : 2022/05/13 10:52 오전
 */
@DisplayName("Utils:String")
class StringUtilsTest {

    @ParameterizedTest
    @CsvSource(value = {"-1:false", "0:true", "a:false", "3 3:false"}, delimiterString = ":")
    @DisplayName("유효한 숫자 여부 판별")
    public void isNumberTest(String given, boolean expected) {
        // When & Then
        assertThat(StringUtils.isValidNumber(given)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("빈값 null 여부 판별")
    public void isEmptyTest(String given, boolean expected) {
        // When & Then
        assertThat(StringUtils.isEmpty(given)).isEqualTo(expected);
    }

    public static Stream isEmptyTest() {
        return Stream.of(
            Arguments.of("", true),
            Arguments.of(null, true),
            Arguments.of(" ", true)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("구분자 없는 빈값, null인 경우 0 반환 처리")
    public void processNotExistDelimiterAndEmptyStringTest(String given) {
        // When & Then
        assertThat(StringUtils.processNotExistDelimiterAndEmptyString(given)).isEqualTo(0);
    }

    private static Stream processNotExistDelimiterAndEmptyStringTest() {
        final String nullStr = null;
        return Stream.of(
            Arguments.of(""),
            Arguments.of(" "),
            Arguments.of(nullStr)
        );
    }

    @Test
    @DisplayName("구분자 없는 단일 숫자 입력인 경우 그대로 반환 처리")
    public void processNotExistDelimiterStringTest() {
        // Given
        final String given = "4";

        // When & Then
        assertThat(StringUtils.processNotExistDelimiterString(given)).isEqualTo(Integer.parseInt(given));
    }

    @Test
    @DisplayName("',' 혹은 ':'을 구분자로 문자열 분리")
    public void splitByCommaOrColonTest() {
        // Given
        final String given = "1,2:3";

        // When
        String[] actual = DelimiterUtils.splitByCommaOrColon(given);

        // Then
        assertAll(
            () -> assertThat(actual).hasSize(3),
            () -> assertThat(actual).containsExactly("1", "2", "3")
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("“//”와 “\\n” 사이에 Custom 구분자로 문자열 분리")
    public void splitByCustomDelimiterTest(String given, String[] expected) {
        // When
        System.out.println(given);
        String[] actual = DelimiterUtils.splitByCustomDelimiter(given);

        // Then
        assertThat(actual).containsExactly(expected);
    }

    // todo 예외 케이스 : 실패 케이스 -> "//|\n1|2|3", 성공 -> "//\\|\n1|2|3",
    private static Stream splitByCustomDelimiterTest() {
        final String[] expected = new String[]{"1", "2", "3"};
        return Stream.of(
            Arguments.of("//;\n1;2;3", expected),
            Arguments.of("//\\|\n1|2|3", expected),
            Arguments.of("//a\n1a2a3", expected),
            Arguments.of("//;\n1:2:3", new String[]{"1:2:3"})
        );
    }
}
