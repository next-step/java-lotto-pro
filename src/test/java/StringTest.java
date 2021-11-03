import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void split() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    void substring() {
        String input = "(1,2)";
        String result = input.substring(input.indexOf('(') + 1, input.indexOf(')'));
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 테스트. 위치 값을 벗어나면 Exception 발생")
    void charAt() {
        String input = "abc";
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThatThrownBy(() -> input.charAt(3))
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range");
    }
}
