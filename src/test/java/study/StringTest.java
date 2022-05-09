package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    @DisplayName("','로 split하면 1과 2로 분리된다.")
    void split_test() {
        // given
        String input = "1,2";

        // when
        String[] result = input.split(",");

        // then
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("substring을 하면 1,2 문자를 반환한다.")
    void subString_test() {
        // given
        String input = "(1,2)";

        // when
        String result = input.substring(1, 4);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {"abc:0:a", "abc:1:b", "abc:2:c"}, delimiter = ':')
    @DisplayName("chartAt함수로 input string에 특정값을 반환한다.")
    void charAt_test(String input, int index, char result) {
        // given - when - then
        assertThat(input.charAt(index)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"abc:-1", "abc:4"}, delimiter = ':')
    @DisplayName("input 길이보다 크거나 작은값 입력시 exception을 호출한다.")
    void charAt_exception_test(String input, int index) {
        // given - when - then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(index)).withMessageMatching("String index out of range: " + index);
    }
}
