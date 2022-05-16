package lotto.domain;

import org.junit.jupiter.api.Test;

import static lotto.common.Messages.LOTTO_NUMBER_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class LottoNumberTest {

    @Test
    void 로또_번호_입력() {
        assertThat(new LottoNumber(1).toString()).isEqualTo("1");
    }

    @Test
    void 로또_번호_입력시_설정된_범위보다_큰_경우_에러가_발생() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber(46))
                .withMessageContaining(LOTTO_NUMBER_OUT_OF_RANGE);
    }

    @Test
    void 로또_번호_입력시_설정된_범위보다_작은_경우_에러가_발생() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber(-10))
                .withMessageContaining(LOTTO_NUMBER_OUT_OF_RANGE);
    }
}
