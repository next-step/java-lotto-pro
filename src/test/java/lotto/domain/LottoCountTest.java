package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoCountTest {

    @Test
    void 자동_로또_개수_구한다() {
        LottoCount lottoCount = new LottoCount(14, 3);
        assertThat(lottoCount.getAutoCount()).isEqualTo(11);
    }

    @Test
    void 자동_로또_개수가_음수일_경우_에러를_발생한다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoCount(3, 14));
    }
}