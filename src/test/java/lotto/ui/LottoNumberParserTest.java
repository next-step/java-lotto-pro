package lotto.ui;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberParserTest {
    @ParameterizedTest(name = "정수가 아닌 값이 포함되어 있습니다. value=[{0}]")
    @ValueSource(strings = {"a,2,3,4,5,6", "1,2,3,#,%,7"})
    void 정수가_아님(final String value) {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> LottoNumberParser.parseLottoNumbers(value));
    }

    @ParameterizedTest(name = "로또 개수와 다릅니다. value=[{0}]")
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 로또_개수가_아님(final String value) {
        assertThatExceptionOfType(LottoNumberSizeException.class)
                .isThrownBy(() -> LottoNumberParser.parseLottoNumbers(value));
    }
}
