import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("split 메소드 테스트1 - 구분자가 input에 존재 O")
    void splitTest1() {
        String input = "1,2";
        String[] inputArray = input.split(",");
        assertThat(inputArray).contains("2", "1");
        assertThat(inputArray).containsExactly("1", "2");
    }

    @Test
    @DisplayName("split 메소드 테스트2 - 구분자가 input에 존재 X")
    void splitTest2() {
        String input = "1";
        String[] inputArray = input.split(",");
        assertThat(inputArray).containsExactly("1");
        assertThat(inputArray).containsOnly("1");
    }

    @Test
    @DisplayName("substring 메소드 테스트 - () 제거 확인")
    void substringTest() {
        String input = "(1,2)";
        assertThat(input.substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메소드 테스트1 - 특정 위치 문자 확인")
    void charAtTest1() {
        String input = "abc";
        assertThat(input.charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt 메소드 테스트2 - IndexOutOfBoundsException 발생(hasMessage)")
    void charAtTest2() {
        String input = "abc";
        assertThatThrownBy(() -> {
            assertThat(input.charAt(4)).isEqualTo('a');
                }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 4");
    }

    @Test
    @DisplayName("charAt 메소드 테스트3 - IndexOutOfBoundsException 발생(withMessageMatching)")
    void charAtTest3() {
        String input = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    input.charAt(4);
                }).withMessageMatching("String index out of range: \\d+");
    }
}
