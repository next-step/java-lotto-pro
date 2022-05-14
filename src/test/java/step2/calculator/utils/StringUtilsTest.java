package step2.calculator.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author : choi-ys
 * @date : 2022/05/14 7:39 오후
 */
@DisplayName("Utils:StringUtils")
class StringUtilsTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("문자열의 빈값 혹은 Null 여부 판별")
    public void isNullOrEmptyTest(String given) {
        // When & Then
        assertThat(StringUtils.isNullOrEmpty(given)).isTrue();
    }

    private static Stream isNullOrEmptyTest() {
        final String nullString = null;
        return Stream.of(
            Arguments.of(""),
            Arguments.of(nullString)
        );
    }
}