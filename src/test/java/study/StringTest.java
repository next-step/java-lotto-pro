package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    void split() {
        String[] split = "1,2".split(",");
        assertThat(split).containsExactly("1", "2");

        split = "1".split(",");
        assertThat(split).containsExactly("1");
    }

    @Test
    void substring() {
        String word = "(1,2)";
        String substring = word.substring(1, word.length() - 1);
        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("문자열의 특정 위치의 문자 가져오기 테스트")
    @Test
    void chatAt() {
        String word = "abc";
        char first = word.charAt(0);
        char second = word.charAt(1);
        char third = word.charAt(2);

        assertThat(first).isEqualTo('a');
        assertThat(second).isEqualTo('b');
        assertThat(third).isEqualTo('c');

        assertThatThrownBy(() -> word.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> word.charAt(3))
                .withMessageMatching("String index out of range: \\d+");
    }

}
