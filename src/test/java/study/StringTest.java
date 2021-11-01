package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringTest {
    @DisplayName("split 분리 테스트")
    @Test
    void split() {
        String[] result = "1,2".split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("split 구분자를 포함하지 않는 값 테스트")
    @Test
    void split_single() {
        String[] result = "1".split(",");

        assertThat(result).containsExactly("1");
    }

    @DisplayName("substring 테스트")
    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt 특정 위치의 문자를 가져오는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0,a", "1,b", "2,c"})
    void charAt(int index, String expected) {
        String text = "abc";

        assertEquals(expected, String.valueOf(text.charAt(index)));
    }

    @DisplayName("charAt 위치값을 벗어나는 경우 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    void charAt_exception(int index) {
        String text = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> text.charAt(index))
            .withMessageMatching("String index out of range: " + index);
    }
}
