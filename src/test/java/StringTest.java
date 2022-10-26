import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void replace() {
        assertThat("abc".replace("b", "d"))
            .isEqualTo("adc");
    }

    @DisplayName("When split one string, then return string array with exactly same element")
    @Test
    void split_oneString() {
        String[] actual = "1".split(",");
        assertThat(actual)
            .hasSize(1);
        assertThat(actual)
            .containsExactly("1");
    }

    @DisplayName("When split multiple strings, then return string array with exactly same elements")
    @Test
    void split_multipleStrings() {
        String[] actual1 = "1,2".split(",");
        assertThat(actual1)
            .hasSize(2);
        assertThat(actual1)
            .containsExactly("1", "2");
    }

    @DisplayName("문자열의 괄호를 제거할 수 있어야 한다")
    @Test
    void subString() {
        assertThat("(1,2)".substring(1, 4))
            .isEqualTo("1,2");
    }

    @DisplayName("Index base로, 해당 인덱스에 위치한 문자를 가져올 수 있어야 한다")
    @Test
    void charAt() {
        assertThat("abc".charAt(0))
            .isEqualTo('a');
        assertThat("abc".charAt(1))
            .isEqualTo('b');
        assertThat("abc".charAt(2))
            .isEqualTo('c');
        assertThatThrownBy(() -> "abc".charAt(3))
            .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
