package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {

    @Test
    void split_contains() {
        // given
        String input = "1,2";

        // when
        String[] splitResult = input.split(",");

        // then
        assertThat(splitResult).contains("1");
        assertThat(splitResult).contains("2");
    }

    @Test
    void split_contains_exactly() {
        // given
        String input = "1";

        // when
        String[] splitResult = input.split(",");

        // then
        assertThat(splitResult).containsExactly("1");
    }

    @Test
    void substring() {
        // given
        String input = "(1,2)";

        // when
        String result = input.substring(1, 4);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("정상 범위의 값을 가져오는 테스트")
    void charAt() {
        // given
        String input = "abc";

        // when
        char result1 = input.charAt(0);
        char result2 = input.charAt(1);
        char result3 = input.charAt(2);

        // then
        assertThat(result1).isEqualTo('a');
        assertThat(result2).isEqualTo('b');
        assertThat(result3).isEqualTo('c');
    }

    @Test
    @DisplayName("위치 값을 벗어나 Exception 발생하는 테스트")
    void charAt_exception() {
        // given
        String input = "abc";

        // when, then
        assertThatThrownBy(() -> input.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
