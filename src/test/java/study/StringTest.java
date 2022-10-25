package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("split_test_1,2")
    void split() {
        String[] arr = "1,2".split(",");
        assertThat(arr).containsExactly("1", "2");
    }

    @Test
    @DisplayName("split_test_only1")
    void splitOnlyOne() {
        String[] arr = "1,".split(",");
        assertThat(arr).containsExactly("1");
    }

    @Test
    @DisplayName("substring_test")
    void substring() {
        String str = "(1,2)";
        assertThat(str.substring(1, str.length() - 1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt_test")
    void charAt() {
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt_Exception_test")
    void charAtException() {
        String str = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            str.charAt(4);
        }).withMessage("String index out of range: 4");
    }
}
