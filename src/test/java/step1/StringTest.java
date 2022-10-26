package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2"})
    @DisplayName("숫자 2개가 있는 문자를 , 자를때 2개 숫자 문자를 가진 배열이 나온다.")
    void whenSplitText_thenTwoNumbers(String text) {
        String[] numbers = text.split(",");

        assertThat(numbers).contains("1", "2");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,"})
    @DisplayName("숫자 1개가 있는 문자를 , 자를때 1개 숫자 문자를 가진 배열이 나온다.")
    void whenSplitText_thenOneNumber(String text) {
        String[] numbers = text.split(",");

        assertThat(numbers).containsExactly("1");
    }

    @ParameterizedTest
    @CsvSource(value = {"abc:4", "abc:-1"}, delimiter = ':')
    @DisplayName("문자열이 주어질때 문자열 인덱스를 오버하는 인덱스로 charAt 할경우 에러 발생.")
    void givenOutOfIndex_whenCharAt_thenThrowStringIndexOutOfBoundsException(String text, int index) {
        assertThatThrownBy(() -> text.charAt(index))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .withFailMessage("Index: \\d+, Size: \\d+");
    }
}
