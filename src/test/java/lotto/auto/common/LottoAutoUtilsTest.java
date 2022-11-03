package lotto.auto.common;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoAutoUtilsTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "10a0", "0dsaqwe"})
    public void 문자열_숫자변환_예외_확인(String input) {
        assertThatThrownBy(() -> new LottoAutoUtils().stringToNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}