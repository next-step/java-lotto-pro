package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class StringTest {

    @Test
    @DisplayName("String_분리_테스트")
    public void splitTest() {
        String source = "1,2";
        String[] splitResult = source.split(",");
        assertThat(splitResult)
            .containsExactly("1", "2")
            .hasSize(2);
    }

    @Test
    @DisplayName("charAt_OutOfIndexException테스트")
    public void charAtTest() {
        String source = "abc";
        assertThat(source.charAt(0))
            .isEqualTo('a');
        assertThat(source.charAt(1))
            .isEqualTo('b');
        assertThatThrownBy(() -> source.charAt(3))
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessage("String index out of range: 3");
    }

    @Test
    @DisplayName("substring_테스트")
    public void substringTest() {
        String source = "(1,2)";
        assertThat(source.substring(1, 4))
            .isEqualTo("1,2");

        assertThatThrownBy(() -> source.substring(0, 6))
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessage("begin 0, end 6, length 5");
    }
    @Test
    public void asdfasdf (){
        //given
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println(a);
        //when

        //then
    }
}
