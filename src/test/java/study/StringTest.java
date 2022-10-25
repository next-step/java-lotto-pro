package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    //https://github.com/baeksoo/java-lotto-pro.git
    @Test
    @DisplayName("1,2 를 ,로 split 했을 때 1과 2로 잘 분리되는지 테스트")
    void splitTwoDigitsString() {
        // given
        String given = "1,2";

        // when
        String[] result = given.split(",");

        // then
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 테스트")
    void splitOnlyOneDigitString() {
        // given
        String given = "1";

        // when
        String[] result = given.split(",");

        // then
        assertThat(result).containsOnly("1");
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 ( )를 제거 하고 1,2를 반환하는지 테스트")
    void returnRemovedParenthesesDigits() {
        // given
        String given = "(1,2)";

        // when
        String result = given.substring(given.indexOf("(") + 1, given.lastIndexOf(")"));

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc 값이 주어졌을 때 특정 위치의 문자를 가져올 수 있는지 테스트")
    void charAt() {
        // given
        String given = "abc";

        // when && then
        assertThat(given.charAt(0)).isEqualTo('a');
        assertThat(given.charAt(1)).isEqualTo('b');
        assertThat(given.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생 테스트")
    void charAtThrowExceptionWhenCalledWithOutOfIndex() {
        // given
        String given = "abc";

        // when && then
        assertThatThrownBy(() -> given.charAt(-1))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
