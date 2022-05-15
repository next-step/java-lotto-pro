package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputStringUtilsTest {

    @DisplayName("입력된 문자열을 구분자로 split 하고 숫자 리스트로 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:,:6", "1-2-3:-:3"}, delimiter = ':')
    void splitToNumberListByDelimiter(String inputString, String delimiter, int expectedSize) {
        List<Integer> numberList = InputStringUtils.splitToNumberList(inputString, delimiter);
        assertThat(numberList).hasSize(expectedSize);
    }

    @DisplayName("숫자가 아닌 경우 검증")
    @ParameterizedTest
    @CsvSource(value = {"%,2,3,4,5,6:,", "M-2-3:-"}, delimiter = ':')
    void splitToNumberListByDelimiter_not_number(String inputString, String delimiter) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputStringUtils.splitToNumberList(inputString, delimiter))
                .withMessage("[ERROR] 숫자가 아닙니다.");
    }
    @DisplayName("숫자가 아닌경우 검증(wordToNumber)")
    @Test
    void wordToNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputStringUtils.wordToNumber("%%@"))
                .withMessage("[ERROR] 숫자가 아닙니다.");
    }
}
