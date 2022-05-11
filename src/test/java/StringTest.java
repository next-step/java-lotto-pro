import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("'1,2'을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void split_MultiArray() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("'1'을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    void split_SingleArray() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 '1,2'를 반환하는지 확인")
    void substring() {
        String inputValue = "(1,2)";
        String result = inputValue.substring(1, inputValue.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("'abc' 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지 확인")
    void charAt() {
        char result = "abc".charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 IndexOutOfBoundsException 확인")
    void charAt_StringIndexOutOfBoundsException() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> "abc".charAt(3))
            .withMessageMatching("String index out of range: \\d+");
    }

}
