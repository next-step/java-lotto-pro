package calculator.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author : choi-ys
 * @date : 2022/05/13 10:52 오전
 */
@DisplayName("Utils:String")
class StringUtilsTest {

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
}