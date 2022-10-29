package common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import common.constant.ErrorCode;
import common.utils.LongUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LongUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"AB", "A"})
    void 정수가_아닌_값을_parseLong_하면_오류_발생(String textNumber) {
        assertThatThrownBy(() -> LongUtils.parseLong(textNumber))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(ErrorCode.정수값이_아님.getErrorMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"22000000000:22000000000", "23123420302:23123420302"}, delimiter = ':')
    void parseLong_int보다_큰_수_정상_작동(String textNumber, long expectNumber) {
        assertThat(LongUtils.parseLong(textNumber)).isEqualTo(expectNumber);
    }
}
