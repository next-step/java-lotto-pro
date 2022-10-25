package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("String contains 테스트")
    void splitContains() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("String containsExactly 테스트")
    void splitContainExactly() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

}
