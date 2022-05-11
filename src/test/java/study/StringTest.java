package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringTest {

    @Test
    void split() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    void substring() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt으로 특정 위치 문자를 가져올 수 있다")
    void charAt() {
        assertThat("abc".charAt(0)).isEqualTo('a');
        assertThat("abc".charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt 사용시 0보다 작거나 해당 스트링의 크기보다 큰 인덱스값을 요청하면 IndexOutOfBoundsException 발생")
    void charAtException() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(-1));

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(3));
    }
}
