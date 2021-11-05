package calculator;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.ErrorMessage.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Converter 테스트")
class ConverterTest {

    @Test
    @DisplayName("문자열 배열을 정수 배열로 변환한다.")
    public void convert() {
        // given
        String[] tokens = Arrays.array("1", "2", "3");

        // when
        int[] numbers = Converter.convert(tokens);

        // then
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("음수가 포함된 문자열로 변환하면 예외가 발생한다.")
    public void convertThrowException1() {
        // given
        String[] tokens = Arrays.array("-1", "2", "3");

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Converter.convert(tokens))
                .withMessageMatching(NUMBER_ERROR.getMessage());
    }

    @Test
    @DisplayName("숫자가 아닌 문자열로 변환하면 예외가 발생한다.")
    public void convertThrowException2() {
        // given
        String[] tokens = Arrays.array("1", "2", "a");

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Converter.convert(tokens))
                .withMessageMatching(TOKEN_ERROR.getMessage());
    }
}
