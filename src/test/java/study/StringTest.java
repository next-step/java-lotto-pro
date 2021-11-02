package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {
    @Test
    @DisplayName("특정 위치의 문자(',')를 기준으로 분리한다.")
    void split_seperation() {

        // given
        String str = "1,2";
        // when
        String[] ret = str.split("\\,");
        // then
        assertThat(ret).contains("1").contains("2").containsExactly("1", "2");

        // given
        str = "1";
        // when
        ret = str.split("\\,");
        // then
        assertThat(ret).contains("1").containsExactly("1");
    }

    @Test
    @DisplayName("문자열의 앞과 뒤를 제거한다.")
    void substring_bracket() {

        // given
        String str = "(1,2)";
        // when
        String ret = str.substring(1, str.length()-1);
        // then
        assertThat(ret).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져온다.")
    void chatAt_location () {

        // given
        String str = "abc";
        // when-then
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
        assertThatThrownBy(() -> str.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> str.charAt(3)).withMessageMatching("String index out of range: 3");
    }
}
