package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @DisplayName("문자열 분리")
    @Test
    void split() {
        assertThat("1".split(",")).contains("1");
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @DisplayName("문자열 자르기")
    @Test
    void substring() {
        String str = "(1,2)";
        assertThat(str.substring(1, str.length() - 1)).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자 읽기")
    @Test
    void charAt() {
        String str = "abc";
        assertThat(str.charAt(1)).isEqualTo('b');
    }

    @DisplayName("문자열 위치 값을 벗어나면 예외 발생")
    @Test
    void when_outOfBound_then_throwException() {
        String str = "abc";
        assertThatThrownBy(() -> str.charAt(4)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
