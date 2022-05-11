package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("문자열 1,2 를 1과 2 배열로 반환한다")
    void split1() {
        assertThat("1,2".split(",")).contains("1","2");
    }

    @Test
    @DisplayName("문자열 1, 을 1만 포함하는 배열로 반환한다")
    void split2() {
        assertThat("1,".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("문자열 (1,2) 를 문자열 1,2로 반환한다")
    void substring() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 abc 에서 두 번째 인덱스 문자 b를 가져온다")
    void chatAt() {
        assertThat("abc".charAt(1)).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt 인덱스 범위가 벗어나면 StringIndexOutOfBoundsException이 발생한다")
    void charAtException() {
        assertThatThrownBy(() -> "abc".charAt(4)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
