package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author : choi-ys
 * @date : 2022-05-10 오전 3:18
 */
@DisplayName("String Class에 대한 학습 테스트")
public class StringClassTest {
    private static final String INDEX_OUT_OF_BOUNDS_EXCEPTION_MESSAGE_FORMAT = "String index out of range";

    @ParameterizedTest
    @MethodSource
    @DisplayName("split() : 구분자를 기준으로 주어진 문자열을 split 하여 반환된 배열의 원소 포함 여부 검증")
    public void splitTest(String given, String[] expected) {
        // When
        final String delimiter = ",";
        final String[] actual = given.split(delimiter);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Then
        assertAll(
            () -> assertThat(actual).as("split을 통해 반환된 배열의 원소 포함 여부 검증").contains(expected),
            () -> assertThat(actual).as("split을 통해 반환된 배열의 전체 원소 일치 여부 검증").containsExactly(expected)
        );
    }

    private static Stream splitTest() {
        return Stream.of(
            Arguments.of("1,2", new String[]{"1", "2"}),
            Arguments.of("1", new String[]{"1"})
        );
    }

    @Test
    @DisplayName("substring() : 시작/종료 Index를 기준으로 자른 문자열 검증")
    public void substringTest() {
        // Given
        final String given = "(1,2)";
        final String expected = "1,2";
        final String startDelimiter = "(";
        final String endDelimiter = ")";
        final int firstIndex = substringFirstIndex(given, startDelimiter);
        final int lastIndex = given.indexOf(endDelimiter);

        // When
        String actual = given.substring(firstIndex, lastIndex);

        // Then
        assertThat(actual).as("substring을 통해 잘린 문자열 검증").isEqualTo(expected);
    }

    private int substringFirstIndex(String given, String delimiter) {
        return given.indexOf(delimiter) + 1;
    }

    @Test
    @DisplayName("substring() : 유효하지 못한 substring 범위인 경우 발생하는 예외 검증")
    public void substringExceptionTest() {
        // Given
        final String given = "(1,2)";

        // When & Then
        assertThatThrownBy(() -> given.substring(0, given.length() + 1))
            .isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining(INDEX_OUT_OF_BOUNDS_EXCEPTION_MESSAGE_FORMAT);
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> given.substring(given.length(), 0))
            .withMessageContaining(INDEX_OUT_OF_BOUNDS_EXCEPTION_MESSAGE_FORMAT);
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("charAt() : 주어진 문자열의 특정 Index 위치의 문자 반환 여부 검증")
    public void charAtTest(String given, int index, char expected) {
        // When
        char actual = given.charAt(index);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> charAtTest() {
        final String given = "abc";
        return Stream.of(
            Arguments.of(given, 0, 'a'),
            Arguments.of(given, 1, 'b'),
            Arguments.of(given, 2, 'c')
        );
    }

    @Test
    @DisplayName("charAt() : index 범위를 벗어나서 발생하는 IndexOutOfBoundsException 예외 검증")
    public void indexOutOfBoundException() {
        // Given
        final String given = "abc";

        // When & Then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> given.charAt(4))
            .withMessageContaining(INDEX_OUT_OF_BOUNDS_EXCEPTION_MESSAGE_FORMAT);
    }
}
