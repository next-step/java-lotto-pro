import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("1,2 문자열 나누기")
    void splitMultipleString() {
        String[] result = "1,2".split(",");

        assertThat(result).contains("1","2");
    }

    @Test
    @DisplayName("1 문자열 나누기")
    void splitSingleString() {
        String[] result1 = "1".split(",");

        assertThat(result1).containsExactly("1");
    }

    @Test
    @DisplayName("괄호 안의 문자열 가져오기")
    void substring() {
        String result = "(1,2)".substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져오기")
    void charAt() {
        String str = "abc";

        char c0 = str.charAt(0);
        char c1 = str.charAt(1);
        char c2 = str.charAt(2);

        assertThat(c0).isEqualTo('a');
        assertThat(c1).isEqualTo('b');
        assertThat(c2).isEqualTo('c');
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어난 경우")
    void charAtOutOfBoundsException() {
        assertThatThrownBy(() -> "abc".charAt(4)
        ).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
