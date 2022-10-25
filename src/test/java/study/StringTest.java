package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @DisplayName("1,2 분리")
    @Test
    void split_strings() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("1만 분리")
    @Test
    void split_string() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }
}
