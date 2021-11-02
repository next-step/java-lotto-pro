package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    public static final String SEPARATOR = ",";

    @ParameterizedTest
    @ValueSource(strings = {"1,2"})
    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
    void split(String input) {
        assertThat(input.split(SEPARATOR)).containsExactly("1", "2");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1"})
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트")
    void split2(String input) {
        assertThat(input.split(SEPARATOR)).contains("1");
    }

    @DisplayName("abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    void charAt(int index, char singleStr) {
        String str = "abc";
        assertThat(str.charAt(index)).isEqualTo(singleStr);
    }

    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트")
    @Test
    void charAtException() {
        String str = "abc";
        assertThatThrownBy(() -> str.charAt(str.length()))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
