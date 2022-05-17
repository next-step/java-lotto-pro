package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.common.Messages.LOTTO_NUMBERS_SEPARATOR;
import static lotto.common.Messages.LOTTO_NUMBERS_SIZE;
import static lotto.domain.LottoPassive.splitPassiveNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class LottoPassiveTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void 수동_로또_번호_정상_입력_검증(String string) {
        assertThat(splitPassiveNumber(string).length).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456"})
    void 수동_로또_번호_구분자_검증(String string) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> splitPassiveNumber(string))
                .withMessageContaining(LOTTO_NUMBERS_SEPARATOR);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5"})
    void 수동_로또_번호_개수_검증(String string) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> splitPassiveNumber(string))
                .withMessageContaining(LOTTO_NUMBERS_SIZE);
    }
}
