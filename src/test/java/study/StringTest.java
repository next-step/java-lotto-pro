package study;

import static java.lang.String.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    void split_1_2() {
        String[] strings = "1,2".split(",");
        assertThat(strings).contains("1", "2");
        assertThat(strings).containsExactly("1", "2");
    }

    @Test
    void split_1() {
        String[] strings = "1".split(",");
        assertThat(strings).contains("1");
        assertThat(strings).containsExactly("1");
    }

    @Test
    void split_1_2_brace() {
        final String s = "(1,2)";
        String[] strings = s.substring(1, s.length() - 1)
                .split(",");
        assertThat(strings).contains("1", "2");
        assertThat(strings).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항 3 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
    void split_abc_charAt() {
        final String s = "abc";
        String[] strings = new String[s.length()];

        for (int i = 0; i < s.length(); i++) {
            strings[i] = valueOf(s.charAt(i));
        }

        assertThat(strings).contains("a", "b", "c");
        assertThat(strings).containsExactly("a", "b", "c");
    }

    @Test
    @DisplayName("요구사항 3 charAt() 메소드를 활용해 특정 위치의 문자 가져올 때 StringIndexOutOfBoundsException 발생 테스트")
    void split_abc_charAt_exception() {
        final String s = "abc";

        assertThatThrownBy(() -> valueOf(s.charAt(s.length() + 1)))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
