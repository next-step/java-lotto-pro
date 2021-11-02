import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
