package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class StringTest {

    @Test
    @DisplayName("문자열을 쉼표(,)로 스플릿 하여 배열을 리턴한다.")
    void splitString() {
        String input1 = "1,2";
        String[] result1 = input1.split(",");
        Assertions.assertThat(result1).containsExactly("1", "2");

        String input2 = "1";
        String[] result2 = input2.split(",");
        Assertions.assertThat(result2).contains("1");

    }

    @Test
    @DisplayName("substring() 메서드는 부분 문자열을 리턴한다")
    void subString() {
        String input = "(1,2)";
        String result = input.substring(1, 4);
        Assertions.assertThat(result).isEqualTo("1,2");
    }


    @Test
    @DisplayName("charAt() 메서드는 문자열 위치반환, 벗어나면 StringIndexOutOfBoundsException 발생")
    void charAt() {
        String input = "abc";
        Assertions.assertThat(input.charAt(1)).isEqualTo('b');
        Assertions.assertThat(input.charAt(2)).isEqualTo('c');
        int index = 3;
        Assertions.assertThatThrownBy(() -> {
                    input.charAt(index);
                }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining(String.format("String index out of range: %s", index));

    }

}
