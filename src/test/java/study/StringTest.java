package study;

import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    @DisplayName("1,2를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void split_1_2() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    void split_1() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 substring() 메소드를 활용해 1,2 반환되는지 확인")
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @ParameterizedTest
    @DisplayName("abc 값이 주어졌을 때 charAt() 메소드를 활용해 특정 위치의 문자 확인")
    @CsvSource(value = {"0,a", "1,b", "2,c"})
    void charAt(int index, char expected) {
        char alphabet = "abc".charAt(index);
        assertThat(alphabet).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("charAt() 메소드를 활용해 특정 위치 값 벗어났을 때 Exception 발생 확인")
    @ValueSource(ints = {-1, 4})
    void charAtException(int index) {
        assertAll(
                () -> assertThatThrownBy(() -> {
                    "abc".charAt(index);
                }).isInstanceOf(IndexOutOfBoundsException.class)
                        .hasMessageContaining("String index out of range: %d", index)
        );
    }
}
