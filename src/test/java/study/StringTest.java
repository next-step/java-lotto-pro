package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringTest {

    @Test
    @DisplayName("1,2를 ,로 split할 때 1과 2로 분리되는지 확인")
    void splitTest() {
        String input = "1,2";

        String[] results = input.split(",");

        Assertions.assertThat(results).contains("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 split할 때 1만을 포함하는 배열이 반환되는지 확인")
    void splitTest2() {
        String input = "1";

        String[] results = input.split(",");

        Assertions.assertThat(results).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2)을 substring으로 ()을 제거할 때 1,2가 반환되는지 확인")
    void substringTest() {
        String input = "(1,2)";

        String results = input.substring(1, input.length() - 1);

        Assertions.assertThat(results).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    @DisplayName("charAt으로 abc 문자열의 특정 위치의 문자 반환")
    void charAtTest(int index, char expected) {
        String input = "abc";

        char results = input.charAt(index);

        Assertions.assertThat(results).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    @DisplayName("charAt이 index를 벗어날 경우 StringIndexOutOfBoundsException 발생")
    void charAtExceptionTest(int index) {
        String input = "abc";
        Assertions.assertThatThrownBy(() -> input.charAt(index))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining(String.format("String index out of range: %d", index));
    }

}