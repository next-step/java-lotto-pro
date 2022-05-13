package calculator.utils;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.utils.DelimiterUtils;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author : choi-ys
 * @date : 2022/05/12 10:51 오후
 */
@DisplayName("Validator:Delimiter")
class DelimiterUtilsTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("',' or ':' 구분자 포함 여부 판별")
    public void hasDelimiterTest(String given, boolean expected) {
        // When & Then
        assertThat(DelimiterUtils.hasDelimiter(given)).isEqualTo(expected);
    }

    private static Stream hasDelimiterTest() {
        return Stream.of(
            Arguments.of("1,2:3", true),
            Arguments.of(",123", true),
            Arguments.of("123:", true),
            Arguments.of("1;2;3", false)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("“//”와 “\\n” 사이에 Custom 구분자 포함 여부 판별")
    public void hasCustomDelimiterTest(String given, boolean expected) {
        // When & Then
        assertThat(DelimiterUtils.hasCustomDelimiter(given)).isEqualTo(expected);
    }

    private static Stream hasCustomDelimiterTest() {
        return Stream.of(
            Arguments.of("//;\n1;2;3", true),
            Arguments.of(";\n1;2;3", false),
            Arguments.of("//;1;2;3", false),
            Arguments.of(";1;2;3", false),
            Arguments.of("\\;\n1;2;3", false),
            Arguments.of("\\\n1;2;3", false)
        );
    }
}
