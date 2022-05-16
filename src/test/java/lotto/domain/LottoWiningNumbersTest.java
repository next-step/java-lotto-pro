package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.common.Messages.LOTTO_NUMBERS_SIZE;
import static lotto.common.Messages.LOTTO_WINING_SEPARATOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class LottoWiningNumbersTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void 지난주_당첨_번호_입력(String string) {
        LottoWiningNumbers lottoWiningNumbers = new LottoWiningNumbers(string);

        LottoNumbers generate = lottoWiningNumbers.generate();

        assertThat(generate.getLottoNumbers()).size().isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345"})
    void 지난주_당첨_번호_입력시_구분자_오류(String string) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoWiningNumbers(string))
                .withMessageContaining(LOTTO_WINING_SEPARATOR);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4"})
    void 지난주_당첨_번호_입력시_당첨_번호_개수_오류(String string) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoWiningNumbers(string))
                .withMessageContaining(LOTTO_NUMBERS_SIZE);
    }
}
