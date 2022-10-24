package learningtest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringTest {

    @Test
    void 숫자_1과_2_를_콤마로_split_했을_때_1과_2로_분리된다() {
        String 숫자_1과_2 = "1,2";
        String[] 분리된_1과_2 = 숫자_1과_2.split(",");

        assertThat(분리된_1과_2).containsExactly("1", "2");
    }

    @Test
    void 숫자_1을_콤마로_split_했을_때_1만을_포함하는_배열이_반환된다() {
        String 숫자1 = "1";
        String[] 숫자1만_포함된_배열 = 숫자1.split(",");

        assertThat(숫자1만_포함된_배열).contains("1");
    }

    @Test
    void 괄호로_둘러싸인_1과_2값이_주어졌을_때_String의_substring_메소드를_활용해_괄호를_제거하고_1과2가_반환된다() {
        String 숫자1과_2 = "(1,2)";
        String 괄호_없는_1과_2 = 숫자1과_2.substring(숫자1과_2.indexOf("(")+1, 숫자1과_2.indexOf(")"));

        assertThat(괄호_없는_1과_2).isEqualTo("1,2");
    }
}
