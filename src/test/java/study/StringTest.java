package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void splitMultiElement() {
        String[] result = "1,2" .split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void splitOneElement() {
        String[] result = "1" .split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substringInput() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

}
