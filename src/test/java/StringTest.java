import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    public void test_split_contains_1_or_2() {
        String[] underTest = "1,2".split(",");

        assertThat(underTest).contains("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    public void test_split_contains_exactly_1() {
        String[] underTest = "1".split(",");

        assertThat(underTest).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2)을 substring 했을 때 시작, 끝 index를 지정해주면 ()을 제거하고 1,2를 반환하는지 확인")
    public void test_substring() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @ParameterizedTest
    @DisplayName("abc 값이 주어졌을 때 charAt 하여 특정 위치의 Character 타입 문자를 가져올 수 있는지 확인")
    @CsvSource(value = { "0:a", "1:b", "2:c" }, delimiterString = ":")
    public void test_charAt(Integer index, Character character) {
        String underTest = "abc";

        assertThat(underTest.charAt(index)).isEqualTo(character);
    }

    @ParameterizedTest
    @DisplayName("abc 값이 주어졌을 때 charAt 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지 확인")
    @ValueSource(ints = { 3, -1, Integer.MAX_VALUE })
    public void test_charAt_throw_StringIndexOutOfBoundsException(Integer index) {
        String underTest = "abc";
        String exceptionMessage = "String index out of range:";

        assertThatThrownBy(() -> underTest.charAt(index)).isExactlyInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining(exceptionMessage);
    }

}
