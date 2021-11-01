package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @DisplayName("문자열을 구분자로 split하면 나누어진 문자열 배열이 반환된다")
    @Test
    void testSplit() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
        assertThat("1,".split(",")).containsExactly("1");
    }
}
