package learning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringTest {

    private static final String DELIMITER = ",";
    private static final int DELETE_SIDE_LENGTH = 1;

    @Test
    @DisplayName("split() 메소드를 통해 문자열을 분리하여 배열로 반환되는지 확인한다.")
    void split() {
        //given
        String input1 = "1,2";
        String input2 = "1";

        //when
        String[] result1 = input1.split(DELIMITER);
        String[] result2 = input2.split(DELIMITER);

        //then
        assertThat(result1).containsExactly("1", "2");
        assertThat(result2).containsExactly("1");
    }

    @Test
    @DisplayName("substring() 메소드를 통해 문자열의 앞뒤로 한칸씩을 제거한다.")
    void subString() {
        //given
        String input = "(1,2)";

        //when
        String result = input.substring(DELETE_SIDE_LENGTH, input.length() - DELETE_SIDE_LENGTH);

        //then
        assertThat(result).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {"0, a", "1, b", "2, c"})
    @DisplayName("charAt() 메소드를 통해 특정 문자의 위치를 확인한다.")
    void charAt(int index, char excepted) {
        //given
        String input = "abc";

        //when
        char result = input.charAt(index);

        //then
        assertThat(result).isEqualTo(excepted);
    }

    @Test
    @DisplayName("charAt() 메소드에서 문자열 위치 값을 벗어나면 예외가 발생한다.")
    void validateBoundCharAt() {
        //given
        String input = "abc";

        //when
        int invalid = 3;

        //then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(invalid))
                .withMessageMatching("String index out of range: \\d+");
    }
}
