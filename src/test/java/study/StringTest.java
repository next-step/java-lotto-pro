package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("\"1,2\"를 split 한 경우 \"1\"과 \"2\"로 분리")
    @Test
    void string_comma_split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
        assertThat(result).hasSize(2);
    }

    @DisplayName("\"1\"을 ,로 split 한 경우 1만 포함된 배열 확인")
    @Test
    void string_comma_1() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
        assertThat(result).hasSize(1);
    }

    @DisplayName("\"(1,2)\"를 substring()을 활용해 '()'제거하면 \"1,2\"를 반환")
    @Test
    void substring_parentheses() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("\"abc\" 값이 주어진 경우 charAt() 메소드의 특정 위치 확인 및 Exception 확인")
    @Test
    void abc_char_at_exception() {
        String result = "abc";
        assertThat(result.charAt(0)).isEqualTo('a');
        assertThat(result.charAt(1)).isEqualTo('b');
        assertThat(result.charAt(2)).isEqualTo('c');
        assertThatThrownBy(() -> result.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

}