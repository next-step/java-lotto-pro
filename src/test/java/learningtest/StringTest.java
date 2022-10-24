package learningtest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringTest {

    @Test
    @DisplayName("'1,2'을 ,로 split 했을 때 1과 2로 각각 분리된다")
    void testSplitComma() {
        String 숫자_1과_2 = "1,2";
        String[] 분리된_1과_2 = 숫자_1과_2.split(",");

        assertThat(분리된_1과_2).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환된다")
    void testSplitCommaWithOnlyContains1() {
        String 숫자1 = "1";
        String[] 숫자1만_포함된_배열 = 숫자1.split(",");

        assertThat(숫자1만_포함된_배열).contains("1");
    }

    @Test
    @DisplayName("'(1,2)' 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 '1,2'를 반환한다")
    void testRemoveParentheses() {
        String 숫자1과_2 = "(1,2)";
        String 괄호_없는_1과_2 = 숫자1과_2.substring(숫자1과_2.indexOf("(")+1, 숫자1과_2.indexOf(")"));

        assertThat(괄호_없는_1과_2).isEqualTo("1,2");
    }

    @Test
    @DisplayName("'abc' 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다")
    void testCharAt() {
        String abc = "abc";
        assertThat(abc.charAt(0)).isEqualTo('a');
        assertThat(abc.charAt(1)).isEqualTo('b');
        assertThat(abc.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다")
    void testCharAtStringIndexOutOfBoundsException() {
        String abc = "abc";
        assertThatThrownBy(() -> abc.charAt(abc.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
