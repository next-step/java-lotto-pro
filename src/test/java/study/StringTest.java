package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("1과 2로 잘 분리되는 확인")
    void split() {
        String[] split = "1,2".split(",");
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    void splitOne() {
        String[] split = "1".split(",");
        assertThat(split).contains("1");
        assertThat(split.length).isEqualTo(1);
    }

    @Test
    @DisplayName("subString을 사용해서 () 제거")
    void removeParenthesis() {
        String substring = "(1,2)".substring(1, 4);
        assertThat(substring).contains("1,2");
    }


    @Test
    @DisplayName("charAt을 이용해 특정문자의 위치를 가져오기")
    void charAt() {
        char c = "abc".charAt(1);
        assertThat(c).isEqualTo('b');
    }

    @Test
    @DisplayName("특정 위치의 문자 범위 넘어간 숫자를 가져오는 경우 Exception 발생")
    void charAt_StringIndexOutOfBoundsException() {
        assertThatThrownBy(() -> {
            char c = "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
