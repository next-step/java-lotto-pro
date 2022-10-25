package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @DisplayName("1,2 분리")
    @Test
    void split_strings() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("1만 분리")
    @Test
    void split_string() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @DisplayName("(1,2)일 때 ()제거하고 1,2만 반환")
    @Test
    void substring() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자 가져오기")
    @Test
    void charAt() {
        char result1 = "abc".charAt(0);
        char result2 = "abc".charAt(1);
        char result3 = "abc".charAt(2);

        assertThat(result1).isEqualTo('a');
        assertThat(result2).isEqualTo('b');
        assertThat(result3).isEqualTo('c');
    }

    @DisplayName("위치 값 벗어났을 때 exception")
    @Test
    void charAt_exception() {
        String input = "abc";
        assertThatThrownBy(() -> input.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
