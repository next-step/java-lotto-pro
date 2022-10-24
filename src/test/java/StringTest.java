import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 구분자(,)를 통해 split 했을 때 1과 2로 분리된다.")
    void splitTest1() {
        String[] inputArray = "1,2".split(",");
        assertThat(inputArray).contains("1", "2");
        assertThat(inputArray).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 구분자(,)를 통헤 split 했을 때 1만 반환한다.")
    void splitTest2() {
        String[] inputArray = "1".split(",");
        assertThat(inputArray).contains("1");
        assertThat(inputArray).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환한다.")
    void splitTest3() {
        String substring = "(1,2)".substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다.")
    void splitTest4() {
        String input = "abc";
        assertAll(
                () -> assertThat(charAt(input, 0)).isEqualTo('a'),
                () -> assertThat(charAt(input, 1)).isEqualTo('b'),
                () -> assertThat(charAt(input, 2)).isEqualTo('c')
        );
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    void splitTest5() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    String input = "abc";
                    charAt(input, input.length());
                }).withMessageMatching("String index out of range: \\d+");
    }

    private char charAt(String input, int index) {
        return input.charAt(index);
    }
}