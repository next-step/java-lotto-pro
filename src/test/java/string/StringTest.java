package string;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

    private static final String DELIMITER = ",";

    @DisplayName("1,2를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인한다.")
    @Test
    public void split() {
        String[] result = "1,2".split(DELIMITER);
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인한다.")
    @Test
    public void split2() {
        String[] result = "1".split(DELIMITER);
        assertThat(result).containsExactly("1");
    }

    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환하도록 구현한다.")
    @Test
    public void substring() {
        String result = "(1,2)".substring(1, 4);
        assertEquals("1,2", result);
    }

    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져온다.")
    @CsvSource(value = {"0,a", "1,b", "2,c"})
    @ParameterizedTest
    public void charAt(int index, char expected) {
        String alphabet = "abc";
        char result = alphabet.charAt(index);
        assertEquals(expected, result);
    }

    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생")
    @ValueSource(ints = {-1, 3})
    @ParameterizedTest
    public void charAt_fail(int index) {
        String alphabet = "abc";
        assertThatThrownBy(() -> alphabet.charAt(index))
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining(String.format("String index out of range: %d", index));
    }

}
