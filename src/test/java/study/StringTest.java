package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("문자열 split 테스트")
    public void split_test() {
        assertThat("1,2".split(",")).contains("1", "2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("문자열 substring 테스트")
    public void substring_test() {
        String word = "(1,2)";
        assertThat(word.substring(word.indexOf("(") + 1, word.indexOf(")"))).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 charAt 특정 위치값 테스트")
    public void charAt_test() {
        assertThat("abc".charAt(0)).isEqualTo('a');
        assertThat("abc".charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("문자열 charAt 잘못된 길이 예외 처리 테스트")
    public void charAt_exception_test() {
        assertThatThrownBy(() -> "abc".charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("range: 3");
    }
}
