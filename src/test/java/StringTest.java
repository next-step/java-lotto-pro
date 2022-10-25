import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    private static final String DELIMITER = ",";


    @Test
    @DisplayName("문자열 1,2 을 ','로 분리")
    void string_split() {
        String testCase = "1,2";
        assertThat(testCase.split(DELIMITER)).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열 1을 ','로 분리")
    void string_split_one_element() {
        String testCase = "1";
        assertThat(testCase.split(DELIMITER)).contains("1");
    }

    @Test
    @DisplayName("문자열 (1,2)에서 ()제거 하여 1,2 반환")
    void string_substring() {
        String testCase = "(1,2)";
        int firstIndex = testCase.indexOf("(");
        int lastIndex = testCase.indexOf(")");
        assertThat(testCase.substring(firstIndex + 1, lastIndex)).isEqualTo("1,2");
    }

    @ParameterizedTest
    @DisplayName("문자열 abc에서 특정 문자 반환")
    @MethodSource("provideStringForCharAt")
    void string_char_at(String testCase, int index, char expect) {
        assertThat(testCase.charAt(index)).isEqualTo(expect);
    }

    @ParameterizedTest
    @DisplayName("문자열 abc에서 특정 문자 반환 시 exception")
    @MethodSource("provideStringForCharAtException")
    void string_char_at_exception(String testCase, int index) {
        assertThatThrownBy(() -> testCase.charAt(index)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

    private static Stream<Arguments> provideStringForCharAt() {
        return Stream.of(
                Arguments.of("abc", 0, 'a'),
                Arguments.of("abc", 1, 'b'),
                Arguments.of("abc", 2, 'c')
        );
    }

    private static Stream<Arguments> provideStringForCharAtException() {
        return Stream.of(
                Arguments.of("abc", Integer.MIN_VALUE),
                Arguments.of("abc", Integer.MAX_VALUE)
        );
    }


}
