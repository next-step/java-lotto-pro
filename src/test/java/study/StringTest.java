package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("입력값_1과2로_입력시_1과2가_배열로_분리되어_반환된다")
    void inputSplit() {
        // given
        String input = "1,2";

        // when
        String[] result = input.split(",");

        // then
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("입력값_1_입력시_1로_배열이_반환된다")
    void inputSplit2() {
        // given
        String input = "1";

        // when
        String[] result = input.split(",");

        // then
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("입력값이_괄호를_포함한_경우_괄호를_제거하고_반환한다")
    void substring() {
        // given
        String input = "(1,2)";

        int beginIndex = input.indexOf("(") + 1;
        int endIndex = input.indexOf(")");

        // when
        String substring = input.substring(beginIndex, endIndex);

        // then
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc 값이 주어진 경우 charAt를 활용하여 특정 문자 위치를 반환한다.")
    void charAt() {
        // given
        String input = "abc";

        // when
        // then
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("주어진 String 값에 특정 문자 위치가 벗어난다면 IndexOutOfBoundsException 이 발생된다.")
    void charAtOfException() {
        // then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(10))
                .withMessageMatching("String index out of range: \\d+");
    }
}
