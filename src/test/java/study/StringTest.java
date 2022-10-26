package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("쉼표(,)를 구분자로 해서 문자열 \"1,2\"를 split 하면 1, 2를 요소라 갖는 배열이 된다")
    void splitOneCommaTwo() {
        String input = "1,2";
        String[] output = input.split(",");
        assertThat(output).contains("1", "2");
    }

    @Test
    @DisplayName("쉼표(,)를 구분자로 해서 문자열 \"1\"를 split 하면 1 하나만을 요소라 갖는 배열이 된다")
    void splitOne() {
        String input = "1";
        String[] output = input.split(",");
        assertThat(output).containsOnly("1");
    }

    @Test
    @DisplayName("쉼표(,)를 구분자로 해서 문자열 \"(1,2)\"를 split 하면 바깥쪽의 괄호를 제거한 뒤 1, 2를 요소라 갖는 배열이 된다")
    void splitOneCommaTwoInsideParenthesis() {
        String input = "(1,2)";
        String inputReplaced = input.replaceAll("[()]", "");
        String[] output = inputReplaced.split(",");
        assertThat(output).contains("1", "2");
    }

    @Test
    @DisplayName("문자열 abc 에서 0 번째 문자는 문자 a 이다")
    void getCharacterAtIndexZero() {
        String input = "abc";
        Character output = input.charAt(0);
        assertThat(output).isEqualTo('a');
    }

    @Test
    @DisplayName("문자열 abc 에서 1 번째 문자는 문자 b 이다")
    void getCharacterAtIndexOne() {
        String input = "abc";
        Character output = input.charAt(1);
        assertThat(output).isEqualTo('b');
    }

    @Test
    @DisplayName("문자열 abc 에서 2 번째 문자는 문자 c 이다")
    void getCharacterAtIndexTwo() {
        String input = "abc";
        Character output = input.charAt(2);
        assertThat(output).isEqualTo('c');
    }

    @Test
    @DisplayName("문자열 abc 에서 -1 번째 문자를 확인하려고 하면 IndexOutOfBoundException 이 발생한다")
    void getCharacterAtIndexNegativeOne() {
        assertThatThrownBy(() -> {
            String input = "abc";
            Character output = input.charAt(-1);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("문자열 abc 에서 4 번째 문자, 즉 문자열 길이보다 큰 숫자를 인덱스로 해서 접근하면 IndexOutOfBoundException 이 발생한다")
    void getCharacterAtIndexExceedsLength() {
        assertThatThrownBy(() -> {
            String input = "abc";
            Character output = input.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
