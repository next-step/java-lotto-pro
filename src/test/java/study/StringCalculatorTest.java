package study;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StringCalculatorTest {
    static String word;

    @BeforeAll
    static void beforeAll() {
        word = "1,2,3";
    }

    @Test
    @DisplayName(", 구분자 문자열 나누기")
    void split_comma_delimiter_test() {
        String[] words = StringCalculator.split(word);
        assertArrayEquals(new String[]{"1", "2", "3"}, words);
    }

    @Test
    @DisplayName(": 구분자 문자열 나누기")
    void split_colon_delimiter_test() {
        String[] words = StringCalculator.split(word);
        assertArrayEquals(new String[]{"1", "2", "3"}, words);
    }

    @Test
    @DisplayName(", : 혼합 문자열 나누기")
    void split_mix_delimiter_test() {
        String[] words = StringCalculator.split("1,2:3");
        assertArrayEquals(new String[]{"1", "2", "3"}, words);
    }

    @Test
    @DisplayName("사용자 정의 문자열 나누기")
    void split_custom_delimiter_test() {
        String[] words = StringCalculator.split("//;\n1;2;3;4");
        Arrays.stream(words).forEach(System.out::println);
        assertArrayEquals(new String[]{"1", "2", "3", "4"}, words);
    }

}
