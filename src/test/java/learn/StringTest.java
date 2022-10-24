package learn;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    public static final String SPLIT_KEYWORD = ",";

    @Test
    @DisplayName("1,2를 ','로 분리할 경우 1과 2로 분리된다.")
    void string_split_contain_test() {
        assertThat("1,2".split(SPLIT_KEYWORD)).contains("1", "2");
    }

    @Test
    @DisplayName("1을 ','로 분리할 경우 1로 분리된다.")
    void string_split_containExactly_test() {
        assertThat("1".split(SPLIT_KEYWORD)).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2)값에서 ()를 제거할 경우 1,2가 된다.")
    void string_substring_test() {
        String str = "(1,2)";
        assertThat(str.substring(1, str.length() - 1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc 문자열의 1번째 인덱스의 문자는 'b'다.")
    void string_charAt_test() {
        assertThat("abc".charAt(1)).isEqualTo('b');
    }

    @Test
    @DisplayName("abc 문자열의 길이 범위가 아닌 인덱스를 조회 할 경우 예외가 발생한다.")
    void string_charAt_stringIndexOutOfBounds_test() {
        assertThatThrownBy(() -> "abc".charAt(Integer.MAX_VALUE))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range");
    }
}
