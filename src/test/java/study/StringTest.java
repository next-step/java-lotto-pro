package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {
    @Test
    @DisplayName("요구사항_1: '1,2' 을 , 로 split 했을 때 1 과 2 로 분리되는지")
    void split_by_comma_test() {
        String givenString = "1,2";
        String[] split = givenString.split(",");
        assertThat(split).hasSize(2).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항_1: '1' 을 , 로 split 했을 때, 1 만을 포함하는 배열 반환하는지")
    void split_by_comma_test_with_single_value() {
        String givenString = "1";
        String[] split = givenString.split(",");
        assertThat(split).hasSize(1).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항_2: '(1,2)' 값이 주어졌을 때, String 의 substring() 메소드를 활용해 () 을 제거하고 '1,2' 를 반환하는지")
    void substring_test() {
        String givenString = "(1,2)";
        String sub = givenString.substring(1, givenString.length() - 1);
        assertThat(sub).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항_3: 'abc' 값이 주어졌을 때, String 의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지")
    void charAt_test() {
        String givenString = "abc";
        char firstChar = givenString.charAt(0);
        char secondChar = givenString.charAt(1);
        char lastChar = givenString.charAt(2);
        assertThat(firstChar).isEqualTo('a');
        assertThat(secondChar).isEqualTo('b');
        assertThat(lastChar).isEqualTo('c');
    }

    @Test
    @DisplayName("요구사항_3: charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 이 발생하는지")
    void indexOutOfBoundsException_test() {
        String givenString = "abc";
        int boundIndex = 4;

        assertThatThrownBy(() -> givenString.charAt(boundIndex))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + boundIndex);

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> givenString.charAt(boundIndex))
                .withMessageContaining("String index out of range: " + boundIndex);
    }
}
