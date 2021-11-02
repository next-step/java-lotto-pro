import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    void splitTest() {
        //given
        String input = "1,2";

        //when
        String[] inputSplit = input.split(",");

        //then
        assertThat(inputSplit).contains("1");
        assertThat(inputSplit).contains("2");
        assertThat(inputSplit).containsExactly("1","2");
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
