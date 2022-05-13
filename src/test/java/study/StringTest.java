package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    void splitTest01() {
        // given
        String data = "1,2";

        // when
        String[] splitData = data.split(",");

        // then
        assertThat(splitData).contains("1");
        assertThat(splitData).contains("2");
        assertThat(splitData).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    void splitTest02() {
        // given
        String data = "1";

        // when
        String[] splitData = data.split(",");

        // then
        assertThat(splitData).contains("1");
        assertThat(splitData).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    void substringTest01() {
        // given
        String data = "(1,2)";
        int beginIndex = data.indexOf("(") + 1;
        int endIndex = data.indexOf(")");

        // when
        String substringData = data.substring(beginIndex, endIndex);

        // then
        assertThat(substringData).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    void charAtTest01() {
        // given
        String input = "abc";

        // when
        // then
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt() 메소드로 특정위치 문자 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    void charAtStringIndexOutOfBoundsExceptionTest01() {
        // given
        String input = "abc";

        // when
        // then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> input.charAt(input.length()))
            .withMessageMatching("String index out of range: " + input.length());
    }
}
