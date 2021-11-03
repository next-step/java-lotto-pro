package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void substring() {
        String str = "(1,2)";
        String result = str.substring(str.indexOf("(")+1, str.indexOf(")"));
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정  위치의 문자를 가져오는 테스트")
    void charAt() {
        char result = "abc".charAt(2);
        assertThat(result).isEqualTo('c');
    }

    @Test
    @DisplayName("문자열의 범위를 벗어난 index를 charAt메소드의 전달인자로 사용시 예외발생 테스트")
    void charAtUsingInvalidIndex() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(3))
                .withMessageMatching("String index out of range: \\d+");
    }
}
