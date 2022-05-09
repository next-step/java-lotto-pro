package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt Exception 테스트")
    void charAt() {
        String str = "ABCDEF";

        assertThatThrownBy(() -> {
            str.charAt(6);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 6");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
            str.charAt(6);
        }).withMessageMatching("String index out of range: \\d+");
    }
}
