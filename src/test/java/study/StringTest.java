package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @DisplayName("문자나누기_contains")
    @Test
    void 문자나누기_테스트_1() {
        String testString = "1,2";
        String[] splitResult = testString.split(",");

        assertThat(splitResult).contains("1", "2");
    }

    @DisplayName("문자나누기_containsExactly")
    @Test
    void 문자나누기_테스트_2() {
        String testString = "1,2";
        String[] splitResult = testString.split(",");

        assertThat(splitResult).containsExactly("1", "2");
    }

    @DisplayName("문자나누기2_containsExactly")
    @Test
    void 문자나누기_테스트_3() {
        String testString = "1";
        String[] splitResult = testString.split(",");

        assertThat(splitResult).containsExactly("1");
    }

    @DisplayName("문자자르기_isEqualTo")
    @Test
    void 문자자르기_테스트_요구2() {
        String testString = "(1,2)";
        String subStringResult = testString.substring(1, testString.length() - 1);

        assertThat(subStringResult).isEqualTo("1,2");
    }

    @DisplayName("문자추출_문자확인")
    @Test
    void 문자추출_테스트_1() {
        String testString = "abc";
        int position = 1;
        char expectedChar = 'b';
        char resultChar = testString.charAt(position);

        assertThat(resultChar).isEqualTo(expectedChar);
    }

    @DisplayName("문자추출_exception확인_방식1")
    @Test
    void 문자추출_테스트_2_1() {
        String testString = "abc";
        int position = 3;

        assertThatThrownBy(() -> {
            testString.charAt(position);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("index out of")
                .hasMessageMatching("String index out of range: \\d+");
    }

    @DisplayName("문자추출_exception확인_방식2")
    @Test
    void 문자추출_테스트_2_2() {
        String testString = "abc";
        int position = 4;

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
                    testString.charAt(position);
                }).withMessageContaining("out of range")
                .withMessageMatching("String index out of range: \\d+");
    }

}