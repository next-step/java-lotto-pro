package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.in;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @DisplayName("String 값이 주어졌을 때, 쉼표로 문자열을 나눠서 값을 가져오는 지 확인한다.")
    @Test
    void splitMultiElement() {
        String[] result = "1,2" .split(",");
        assertThat(result).containsExactly("1", "2");
    }
    @DisplayName("String 값이 하나로 주어졌을 때, 쉼표로 문자열을 나눴을 때, 기존 하나 값이 나오는지 확인한다.")
    @Test
    void splitOneElement() {
        String[] result = "1" .split(",");
        assertThat(result).containsExactly("1");
    }

    @DisplayName("String 값이 주어졌을 때, 맨앞과 맨뒤의 문자를 잘라서 나오는지 확인한다.")
    @Test
    void substringInput() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("String 값이 주어졌을 때, 특정 위치의 Character 값을 가져온다")
    @Test
    void findCharacter() {
        Character result = "abc".charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @DisplayName("String 값이 주어졌을 때, 문자열 길이에서 벗어난 위치의 Character 값을 가져올 경우 에러를 확인한다.")
    @Test
    void findOutOfBoundCharacter() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> "abc".charAt(5)).withMessageMatching("String index out of range: \\d+");
    }

}
