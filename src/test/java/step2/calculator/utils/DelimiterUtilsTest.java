package step2.calculator.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author : choi-ys
 * @date : 2022/05/14 10:28 오후
 */
@DisplayName("Validation:DelimiterUtils")
class DelimiterUtilsTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("','혹은':'의 구분자 포함 여부")
    public void hasCommaOrColonDelimitersTest(final String given, boolean expected) {
        // When & Then
        assertThat(DelimiterUtils.hasCommaOrColonDelimiters(given)).isEqualTo(expected);
    }

    private static Stream hasCommaOrColonDelimitersTest() {
        return Stream.of(
            Arguments.of("1,2,3", true),
            Arguments.of("1:2:3", true),
            Arguments.of("1,2:3", true),
            Arguments.of("1;2;3", false),
            Arguments.of("123", false),
            Arguments.of("//;\n1;2;3", false)
        );
    }

    @Test
    @DisplayName("“//”와 “\n” 사이에 위치하는 Custom 구분자 포함 여부")
    public void hasCustomDelimiterTest() {
        final String given = "//;\n1;2;3";

        // When & Then
        assertThat(DelimiterUtils.hasCustomDelimiter(given)).isTrue();
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("구분자 종류에 따른 구분자 추출")
    public void extractDelimiterTest(String given, String expected) {
        // When
        assertThat(DelimiterUtils.extractDelimiter(given)).isEqualTo(expected);
    }

    private static Stream extractDelimiterTest() {
        return Stream.of(
            Arguments.of("1,2,3", ","),
            Arguments.of("1:2:3", ":"),
            Arguments.of("1,2:3", ",|:"),
            Arguments.of("//;\n1;2;3", ";")
        );
    }

    @Test
    @DisplayName("Custom 구분자인 경우, Custom 구분자 영역을 제외한 연산 대상 문자열 추출")
    public void extractSplitTargetTest() {
        // Given
        final String given = "//;\n1;2;3";
        final String expected = "1;2;3";

        // When & Then
        assertThat(DelimiterUtils.extractSplitTarget(given)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("구분자를 기준으로 연산 대상 문자열 분리")
    public void splitByDelimiterRegexTest(String given, String delimiters, String[] expected) {
        // When & Then
        assertThat(DelimiterUtils.splitByDelimiterRegex(given, delimiters)).isEqualTo(expected);
    }

    private static Stream splitByDelimiterRegexTest() {
        String[] expected = new String[]{"1", "2", "3"};
        return Stream.of(
            Arguments.of("1,2,3", ",", expected),
            Arguments.of("1:2:3", ":", expected),
            Arguments.of("1,2:3", ",|:", expected)
        );
    }
}