package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String result = "(1,2)";
        result = result.substring(1, result.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        String result = "abc";
        assertThatThrownBy(() -> result.charAt(4))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 4");
    }
}
