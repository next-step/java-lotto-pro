import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("1,2가 주어졌을 때 split을 통해 분리가 가능한지 확인")
    void twoNumberSplitTest() {
        String str = "1,2";
        String[] splitResult = str.split(",");

        assertThat(splitResult.length == 2).isTrue();
        assertThat(splitResult).contains("1", "2");

        assertThat(splitResult).containsExactly("1", "2");

    }

    @Test
    @DisplayName("1,2가 주어졌을 때 split을 통해 분리가 가능한지 확인 (실패)")
    void twoNumberSplitFailTest() {
        String str = "1,2,";
        String[] splitResult = str.split(",");

        assertThat(splitResult.length == 3).isFalse();
        assertThat(splitResult).contains("1", "2");

    }

    @Test
    @DisplayName("(1,2)가 주어졌을 때 substring으로 1,2 추출 후 split을 통해 분리가 가능한지 확인")
    void twoNumberSplitWithSubstringTest() {
        String str = "(1,2)";
        String subStr = str.substring(1,4);
        String[] splitResult = subStr.split(",");

        assertThat(splitResult.length == 2).isTrue();
        assertThat(splitResult).contains("1", "2");

        assertThat(splitResult).containsExactly("1", "2");

        System.out.println("subStr = " + subStr);
    }

    @Test
    @DisplayName("abc에서 charAt을 통해 알파벳 추출, 범위를 벗어났을 때 예외 처리")
    void stringCharAtTest() {
        String str = "abc";

        // get a
        char aChar = str.charAt(0);
        assertThat(aChar).isEqualTo('a');

        // get c
        char cChar = str.charAt(2);
        assertThat(cChar).isEqualTo('c');

        // StringIndexOutOfBoundException
        assertThatThrownBy(() -> {
            str.charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 5");

    }
}
