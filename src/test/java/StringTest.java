import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {

    @Test
    void splitTest() {
        //given
        String input = "1,2";

        //when
        String[] inputSplit = input.split(",");

        //then
        assertThat(inputSplit).containsExactly("1","2");
    }

    @Test
    void delimiterNotMatchInSplitTest() {
        //given
        String input = "1";

        //when
        String[] inputSplit = input.split(",");

        //then
        assertThat(inputSplit).contains("1");
    }

    @Test
    void subStringTest() {
        //given
        String input = "(1,2)";

        //when
        String inputSubstring = input.substring(1,4);

        //then
        assertThat(inputSubstring).contains("1,2");
    }

    @Test
    @DisplayName("문자열 중 한 글자 가져오기")
    void charAtTest() {
        //given
        String input = "abc";

        //when
        char ch = input.charAt(0);

        //then
        assertThat(ch).isEqualTo('a');
    }

    @Test
    @DisplayName("문자열 길이보다 큰 인덱스나 음수 전달시 예외")
    void charAtIndexOutOfRangeTest() {
        //given
        String input = "1,2";

        //when and then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(3))
                .withMessageMatching("String index out of range: \\d+");
    }
}
