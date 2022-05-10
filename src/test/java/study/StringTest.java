package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 분리")
    void split(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열 반환")
    void splitOneElement(){
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 을 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환")
    void substring(){
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 을 charAt() 메소드를 활용해 특정 위치의 문자를 반환")
    void charAt(){
        assertThat("abc".charAt(0)).isEqualTo('a');
        assertThat("abc".charAt(1)).isEqualTo('b');
        assertThat("abc".charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("\"abc\" 을 charAt() 메소드를 활용할 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생")
    void charAtException(){
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(4);
                }).withMessageMatching("String index out of range: \\d+");
    }
}
