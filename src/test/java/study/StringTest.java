package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("'1,2'를 ','로 split 하여 '1', '2'로 잘 분리되는지 확인")
    public void split() {
        //given
        String input = "1,2";

        //when
        String[] result = input.split(",");

        //then
        assertThat(result).contains("1", "2");
    }

    @Test
    @DisplayName("'1'을 ','로 split 하여 '1'만을 포함하는 배열 반환")
    public void splitOnlyOne() {
        //given
        String input = "1";

        //when
        String[] result = input.split(",");

        //then
        assertThat(result).containsExactly("1");
    }
}
