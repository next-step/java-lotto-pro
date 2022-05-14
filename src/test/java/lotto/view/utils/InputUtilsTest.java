package lotto.view.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static lotto.view.utils.InputUtils.convertToInteger;
import static org.assertj.core.api.Assertions.assertThat;

class InputUtilsTest {

    @ParameterizedTest
    @CsvSource(value = {"10000:10000", "13000:13000", "5000:5000", "0:0"}, delimiter = ':')
    @DisplayName("입력받은 숫자를 Integer 타입으로 변환한다.")
    void convertToInteger_string타입_숫자(String input, int expected) {
        assertThat(convertToInteger(input))
                .isExactlyInstanceOf(Integer.class)
                .isEqualTo(expected);
    }

}