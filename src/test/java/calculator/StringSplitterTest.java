package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSplitterTest {

    @ParameterizedTest
    @DisplayName("문자열에 구분자 없이 숫자만 들어있는 경우 해당 숫자 반환")
    @CsvSource(value = {"1:1", "2:2", "3:3", "124:124"}, delimiter = ':')
    void has_not_delimiter(String testCase, String expect) {
        assertThat(StringSplitter.split(testCase)).hasSize(1);
        assertThat(StringSplitter.split(testCase).contains(expect)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("문자열이 빈문자열이거나 null인경우 0반환")
    @NullSource
    @ValueSource(strings = {""})
    void value_empty_or_null(String testCase) {
        assertThat(StringSplitter.split(testCase)).hasSize(1);
        assertThat(StringSplitter.split(testCase).contains("0")).isTrue();
    }

    @ParameterizedTest
    @DisplayName("문자열이 구분자 , 콤마 사용")
    @MethodSource("commaDelimiterStrings")
    void comma_delimiter_and_return_collection(String testCase, List<String> expect) {
        assertThat(StringSplitter.split(testCase)).isEqualTo(expect);
    }

    @ParameterizedTest
    @DisplayName("문자열이 구분자 : 콜론 사용")
    @MethodSource("colonDelimiterStrings")
    void colon_delimiter_and_return_collection(String testCase, List<String> expect) {
        assertThat(StringSplitter.split(testCase)).isEqualTo(expect);
    }

    @ParameterizedTest
    @DisplayName("문자열이 구분자 콜론과콤마 혼용 사용")
    @MethodSource("colonAndCommaDelimiterStrings")
    void colon_and_comma_delimiter_and_return_collection(String testCase, List<String> expect) {
        assertThat(StringSplitter.split(testCase)).isEqualTo(expect);
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자 사용하여 문자열 split")
    @MethodSource("customDelimiterStrings")
    void custom_delimiter_and_return_collection(String testCase, List<String> expect) {
        assertThat(StringSplitter.split(testCase)).isEqualTo(expect);
    }

    private static Stream<Arguments> commaDelimiterStrings() {
        return Stream.of(
                Arguments.of("1,2,3", Arrays.asList("1", "2", "3")),
                Arguments.of("444,666,888", Arrays.asList("444", "666", "888"))
        );
    }

    private static Stream<Arguments> colonDelimiterStrings() {
        return Stream.of(
                Arguments.of("1:2:3", Arrays.asList("1", "2", "3")),
                Arguments.of("444:666:888", Arrays.asList("444", "666", "888"))
        );
    }
    private static Stream<Arguments> colonAndCommaDelimiterStrings() {
        return Stream.of(
                Arguments.of("1:2,3", Arrays.asList("1", "2", "3")),
                Arguments.of("444,666:888", Arrays.asList("444", "666", "888"))
        );
    }
    private static Stream<Arguments> customDelimiterStrings() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", Arrays.asList("1", "2", "3")),
                Arguments.of("//_\n1_2_3", Arrays.asList("1", "2", "3"))
        );
    }
}
