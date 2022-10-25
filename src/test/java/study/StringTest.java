package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("String contains 테스트")
    void stringSplitContains() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("String containsExactly 테스트")
    void stringContainExactly() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("String substring 테스트")
    void stringSubstring() {
        String str = "(1,2)";
        String subStr = str.substring(1, str.length() - 1);

        assertThat(subStr).isEqualTo("1,2");
    }

}
