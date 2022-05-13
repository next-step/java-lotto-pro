package lotto.utils;

import static lotto.utils.StringUtil.isNullOrEmpty;
import static lotto.utils.StringUtil.splitToList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringUtilTest {

    @ParameterizedTest(name = "NULL이거나 EMPTY인 값({0})을 입력받으면 TRUE를 반환")
    @NullAndEmptySource
    void inputNullOrEmpty(String value) {
        assertThat(isNullOrEmpty(value)).isTrue();
    }

    @ParameterizedTest(name = "입력 값({0})이 포맷({1})이 일치하지 않으면 TRUE를 반환")
    @CsvSource(value = {"a:\\d", "1:[2-9]"}, delimiter = ':')
    void inputInvalidFormat(String value, String format) {
        assertThat(StringUtil.isInvalidFormat(value, format)).isTrue();
    }

    @Test
    @DisplayName("입력 값에 NULL 값이 들어오면 IllegalArgumentException이 발생")
    void inputNullInSplitToList() {
        Assertions.assertAll(
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> splitToList(null, ","))
                        .withMessage("문자열이나 구분자가 존재하지 않습니다."),
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> splitToList("abc", null))
                        .withMessage("문자열이나 구분자가 존재하지 않습니다.")
        );
    }

    @Test
    @DisplayName("자른 결과가 일치하는지 검증")
    void verifySplitToList() {
        assertThat(splitToList("1,2,3", ","))
                .hasSize(3)
                .contains("1", "2", "3");
    }
}
