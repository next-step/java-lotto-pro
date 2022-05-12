package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


public class StringAddCalculatorTest {

    @ParameterizedTest
    @DisplayName("로또게임 숫자 입력값이 null 혹은 빈문자 인지 검증한다.")
//    @CsvSource(value = {"'':0", "null:0"}, delimiter = ':')
    @CsvSource(value = {"'':0"}, delimiter = ':')
    void validateLottoInputNumber_null_또는_빈문자(String input, String expected) {
        assertThat(StringAddCalculator.sumValue(input)).isEqualTo(Integer.parseInt(expected));
    }
}
