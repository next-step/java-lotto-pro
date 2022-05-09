package level1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void 요구사항_1_COMMA_로_문자열_split_테스트() {
        String stringNumberWithSplitChar = "1,2";
        String stringNumber = "1";

        String[] resultWithSplitChar = stringNumberWithSplitChar.split(",");
        String[] resultNumber = stringNumber.split(",");

        assertThat(resultWithSplitChar).containsExactly("1", "2");
        assertThat(resultNumber).containsExactly("1");
    }

    @Test
    void 요구사항_2_substring_메서드를_통해_특정_문자_제거_테스트() {
        String leftParentheses = "(";
        String rightParentheses = ")";
        String targetString = "(1,2)";

        String result = targetString.substring(targetString.indexOf(leftParentheses) + 1)
                .substring(0, targetString.indexOf(rightParentheses) - 1);

        assertThat(result).isEqualTo("1,2");
        assertThat(result).doesNotContain(leftParentheses);
        assertThat(result).doesNotContain(rightParentheses);
    }

    @Test
    void 요구사항_3_특정_문자에_charAt_메소드를_활용하여_특정_위치의_문자를_가져오는_테스트() {
        String target = "abc";
        char findChar = 'b';
        int findCharIndex = target.indexOf(findChar);

        char result = target.charAt(findCharIndex);

        assertThat(result).isEqualTo(findChar);
        assertThatThrownBy(() -> target.charAt(target.length() + 1)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
