import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @BeforeEach
    void setup() {
    }

    @Test
    void splitComma() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
        assertThat("1,".split(",")).containsExactly("1");
    }

    @Test
    void substringParenthesis() {
        String value = "(1,2)";
        assertThat(value.substring(1, value.length() -1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc가 주어졌을 때 charAt 메소드가 특정 위치의 문자를 가져오는지 확인")
    void charAt_abc() {
        String value = "abc";
        assertThat(value.charAt(0)).isEqualTo('a');
        assertThat(value.charAt(1)).isEqualTo('b');
        assertThat(value.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("abc의 범위를 벗어난 인덱스를 charAt 메소드에 입력했을 경우 StringIndexOutOfBoundsException 예외 발생 확인")
    void charAt_abcWithException() {
        String value = "abc";

        assertThatThrownBy(() -> {
            value.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessage("String index out of range: 3");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(()-> {
            value.charAt(3);
        }).withMessageMatching("String index out of range: \\d+");
    }
}
