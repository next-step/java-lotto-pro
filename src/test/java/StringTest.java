import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {
    @DisplayName("1,2를 ','로 split하면 1과 2로 분리된다.")
    @Test
    void splitTest1() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @DisplayName("1을 ','로 split하면 1만 반환된다.")
    @Test
    void splitTest2() {
        assertThat("1".split(",")).containsExactly("1");
    }

    @DisplayName("\"(1,2)\" 값이 주어졌을 때, substring() 활용하면 ()을 제거하고 \"1,2\"가 반환된다.")
    @Test
    void substringTest() {
        int indexOfLeftParenthesis = 1;
        int indexOfRightParenthesis = 4;
        assertThat("(1,2)".substring(indexOfLeftParenthesis, indexOfRightParenthesis)).isEqualTo("1,2");
    }

    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다.")
    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    void charAtTest(int index, char expected) {
        assertThat("abc".charAt(index)).isEqualTo(expected);
    }

    @DisplayName("charAt() 메서드 호출시 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    @Test
    void exceptionTest() {
        assertThatThrownBy(() -> "abc".charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
