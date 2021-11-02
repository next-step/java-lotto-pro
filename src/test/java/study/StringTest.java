package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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

    @Test
    @DisplayName("'1,2'를 substring 메소드로 ()를 제거하고 '1,2'를 반환")
    public void substring() {
        //given
        String input = "(1,2)";

        //when
        String result = input.substring(1, 4);

        //then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("'abc'를 charAt 메소드를 활용해 특정 위치 문자를 가져온다.")
    public void charAt() {
        //given
        String input = "abc";

        //when
        char result = input.charAt(1);

        //then
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt 메소드를 활용하여 특정 위치의 문자를 가져올 때 위치값을 벗어나면 StringIndexOutOfBoundsException 예외가 발생한다.")
    public void charAtIndexOutOfBoundsException() {
        //given
        String input = "abc";

        //when-then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(3))
                .withMessageMatching("String index out of range: 3");
    }

}
