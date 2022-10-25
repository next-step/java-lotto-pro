package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringClassTest {
    @Test
    @DisplayName("String Class 요구사항1")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
        result = "1".split(",");
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("String Class 요구사항2")
    void subString() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String Class 요구사항3")
    void charAt() {
        assertThatThrownBy(() -> "abc".charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}
