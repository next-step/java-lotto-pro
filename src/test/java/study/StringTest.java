package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split1() {
        String[] data = "1,2".split(",");
        assertThat(data).contains("1");
        assertThat(data).contains("2");
    }

    @Test
    void split2() {
        String[] data = "1".split(",");
        assertThat(data).containsExactly("1");
    }

    @Test
    void substring() {
        String data = "(1,2)";
        String expected = "1,2";
        assertThat(data.substring(1, data.length() - 1)).isEqualTo(expected);
    }

    @Test
    @DisplayName("charAt() 위치 값을 벗어나는 경우 StringIndexOutOfBoundsException 발생")
    void charAt() {
        String data = "abc";

        assertThatThrownBy(() -> data.charAt(data.length())).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + data.length());
    }
}

