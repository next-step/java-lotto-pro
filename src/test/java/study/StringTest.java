package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringTest {
    @Test
    @DisplayName("1,2를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void split_test() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    void split_one_test() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2)가 주어졌을때 substring()을 활용해 ()를 제거하고 1,2를 반환하는지 확인")
    void substring_test() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }
    
    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    @DisplayName("abc 값이 주어졌을 때 charAt()을 활용해 특정위치의 문자를 가져오는지 확인")
    void charAt_test(int index, char expected) {
        char result = "abc".charAt(index);
        assertThat(result).isEqualTo(expected);
    }
    
    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    @DisplayName("charAt()을 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지 확인")
    void charAt_out_range_throw_exception_test(int index) {
        assertThatThrownBy(() -> "abc".charAt(index))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: %d", index);
    }
}
