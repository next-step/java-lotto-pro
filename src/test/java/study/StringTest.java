package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {

    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    @Test
    void commaSplitTest01() {
        String target = "1,2";

        assertThat(target.split(","))
                .isInstanceOf(String[].class)
                .hasOnlyElementsOfType(String.class)
                .hasSize(2)
                .containsExactly("1", "2");
    }

    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환 확인")
    @Test
    void commaSplitTest02() {
        String target = "1";

        assertThat(target.split(","))
                .isInstanceOf(String[].class)
                .hasOnlyElementsOfType(String.class)
                .hasSize(1)
                .containsExactly("1");
    }

    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환")
    @Test
    void subStringTest01() {
        String target = "(1,2)";

        String result = target.substring(1, target.length() - 1);
        assertEquals("1,2", result);
    }

    @DisplayName("String(abc)이 주어졌을 때 charAt 메소드로 특정 위치의 문자를 잘 가져오는지 확인")
    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {"0,a", "1,b", "2,c"})
    void charAtTest01(int index, char expected) {
        String target = "abc";

        char result = target.charAt(index);
        assertEquals(expected, result);
    }

    @DisplayName("charAt 메소드 사용시 string length를 넘는 값이 들어올 경우 에러처리가 되는지 확인")
    @Test
    void charAtTest02() {
        String target = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char result = target.charAt(-1);
                }).withMessageMatching("String index out of range: -1");


        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char result = target.charAt(target.length());
                }).withMessageMatching("String index out of range: \\d+");
    }
}
