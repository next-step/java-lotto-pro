package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("split메소드는 1,2를 입력하면 1과2가 포함된 배열을 리턴한다")
    void returns_array_containing_1_and_2(){
        //given
        String input = "1,2";

        //when
        String[] result = input.split(",");

        //then
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("split메소드는 1,을 입력하면 1만 리턴한다")
    void returns_only_1(){
        //given
        String input = "1,";

        //when
        String[] result = input.split(",");

        //then
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("substring메소드는 (1,2)를 입력하면 1,2를 리턴한다")
    void returns_1_comma_2(){
        //given
        String input = "(1,2)";

        //when
        String result = input.substring(1,input.length() - 1);

        //then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt메소드는 위치값의 범위를 벗어나면 StringIndexOutOfBoundsException이 발생")
    void throws_StringIndexOutOfBoundsException(){
        //given
        String input = "abc";

        //when,then
        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("charAt메소드는 위치값에 해당하는 문자를 리턴")
    void returns_character_corresponding_position_value(){
        //given
        String input = "abc";

        //when
        char result = input.charAt(1);

        assertThat(result).isEqualTo('b');
    }
}
