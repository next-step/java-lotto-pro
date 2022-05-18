package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.common.Messages.PASSIVE_COUNT_NOT_NUMBER;
import static lotto.common.Messages.PASSIVE_COUNT_OUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class LottoPassiveCountTest {

    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void 로또_정상_수동_설정(String string) {
        LottoGameCount lottoGameCount = new LottoGameCount(3, string);

        assertThat(lottoGameCount.getPassiveCount()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"4"})
    void 로또_게임_설정보다_수동이_번호가_많은_경우(String string) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoGameCount(3, string))
                .withMessageContaining(PASSIVE_COUNT_OUT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a"})
    void 로또_게임_수동_게임_설정시_숫자가_아닌_경우(String string) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoGameCount(3, string))
                .withMessageContaining(PASSIVE_COUNT_NOT_NUMBER);
    }

}
