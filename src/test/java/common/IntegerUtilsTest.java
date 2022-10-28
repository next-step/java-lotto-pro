package common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import common.constant.ErrorCode;
import common.utils.IntegerUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class IntegerUtilsTest {


    @ParameterizedTest
    @ValueSource(strings = {"정", "정수", "정수아님"})
    void 정수가_아닌_값을_parseInt_하면_오류_발생(String textNumber) {
        assertThatThrownBy(() -> IntegerUtils.parseInt(textNumber))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(ErrorCode.정수값이_아님.getErrorMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"12:12", "1:1", "45:45"}, delimiter = ':')
    void parseInt_정상_작동(String textNumber, int expectNumber) {
        assertThat(IntegerUtils.parseInt(textNumber)).isEqualTo(expectNumber);
    }
}
