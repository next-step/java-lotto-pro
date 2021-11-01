package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @DisplayName("문자열을 구분자로 split하면 나누어진 문자열 배열이 반환된다")
    @Test
    void testSplit() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
        assertThat("1,".split(",")).containsExactly("1");
    }

    @DisplayName("문자열을 주어진 범위(beginIndex, endIndex) 만큼 반환한다")
    @Test
    void testSubString() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
        assertThatThrownBy(() -> "(1,2)".substring(5, 6)).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("begin 5, end 6, length 5");
    }

    @DisplayName("문자열에서 주어진 index의 캐릭터를 반환한다")
    @Test
    void testCharAt() {
        assertThat("abc".charAt(0)).isEqualTo('a');
        assertThat("abc".charAt(2)).isEqualTo('c');
        assertThatThrownBy(() ->"abc".charAt(4)).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
