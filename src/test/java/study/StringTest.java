package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @DisplayName("1,2를 comma(,)로 split 하면 1과 2를 포함한 배열이 반환된다")
    @Test
    void splitTest() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @DisplayName("1을 comma(,)로 split 하면 1만을 포함하는 배열이 반환된다")
    @Test
    void splitOneTest() {
        assertThat("1".split(",")).containsExactly("1");
    }

    @DisplayName("(1,2) 값을 substring 메소드를 이용해 1,2를 반환할 수 있다")
    @Test
    void substringTest() {
        String input = "(1,2)";
        assertThat(input.substring(1, input.length() - 1)).isEqualTo("1,2");
    }

    @DisplayName("charAt 메소드로 특정 위치의 문자를 가져올 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    void charAtTest(int index, char expect) {
        assertThat("abc".charAt(index)).isEqualTo(expect);
    }

    @DisplayName("charAt 메소드에 범위를 벗어나는 값이 들어오면 StringIndexOutOfBoundsException이 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    void charAtExceptionTest(int index) {
        assertThatThrownBy(() -> "abc".charAt(index))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining(String.format("String index out of range: %d", index));
    }
}
