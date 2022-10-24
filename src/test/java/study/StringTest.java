package study;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Nested
    @DisplayName("split 메소드 : regex를 기준으로 문자열을 분리한다")
    @TestInstance(Lifecycle.PER_CLASS)
    class StringSplitMethodTest {

        @ParameterizedTest(name = "문자열: [\"{0}\"], Expected: [\"{1}]\"")
        @MethodSource("string_split_expected")
        @DisplayName("regex가 콤마(,)로 주어진다면")
        public void string_split_test(String input, String[] expected) {
            String[] result = input.split(",");

            assertThat(result).containsExactly(expected);
        }

        private Stream<Arguments> string_split_expected() {
            return Stream.of(
                    Arguments.of("1,2", new String[]{"1", "2"}),
                    Arguments.of("2", new String[]{"2"})
            );
        }
    }

    @Nested
    @DisplayName("substring 메소드 : 시작과 끝단 Index로 문자열을 분리한다")
    @TestInstance(Lifecycle.PER_CLASS)
    class StringSubstringMethodTest {

        @ParameterizedTest(name = "문자열: [\"{0}\"], Expected: [\"{1}\"]")
        @MethodSource("string_substring_expected")
        @DisplayName("'($value)' 형태의 문자열인 경우 괄호안의 값을 반환한다")
        void string_substring_test(String input, String expected) {
            String result = input.substring(1, input.length() - 1);

            assertThat(result).contains(expected);
        }

        private Stream<Arguments> string_substring_expected() {
            return Stream.of(
                    Arguments.of("(1,2)", "1,2"),
                    Arguments.of("(3,4,5)", "3,4,5")
            );
        }
    }

    @Nested
    @DisplayName("charAt 메소드 : 문자열에서 주어진 위치의 char 값을 반환한다")
    @TestInstance(Lifecycle.PER_CLASS)
    class StringCharAtMethodTest {

        @ParameterizedTest(name = "문자열: [\"{0}\"], 위치: [{1}], Expected : [\"{2}\"]")
        @MethodSource("string_charAt_success_expected")
        @Order(3)
        @DisplayName("위치가 문자열의 길이를 초과하지 않으면")
        void string_charAt_success_test(String input, int index, char expected) {
            char result = input.charAt(index);

            assertThat(result).isEqualTo(expected);
        }

        private Stream<Arguments> string_charAt_success_expected() {
            return Stream.of(
                    Arguments.of("abc", 2, 'c'),
                    Arguments.of("cdef", 3, 'f'),
                    Arguments.of("ghi", 1, 'h')
            );
        }

        @ParameterizedTest(name = "문자열: [\"{0}\"], 위치: [{1}]")
        @MethodSource("string_charAt_exception_expected")
        @Order(4)
        @DisplayName("위치가 문자열의 길이를 초과하면 [StringIndexOutOfBoundsException]으로 예외처리한다")
        void string_charAt_exception_test(String input, int index) {
            ThrowableAssert.ThrowingCallable when = () -> {
                char result = input.charAt(index);
            };

            assertThatThrownBy(when)
                    .isInstanceOf(StringIndexOutOfBoundsException.class)
                    .hasMessageContaining("String index out of range: " + index);
        }

        private Stream<Arguments> string_charAt_exception_expected() {
            return Stream.of(
                    Arguments.of("abc", 4),
                    Arguments.of("cdef", 5),
                    Arguments.of("ghi", 4)
            );
        }
    }
}