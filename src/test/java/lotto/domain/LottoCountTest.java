package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoCountTest {

    @Test
    void 로또구매_횟수_생성() {
        LottoCount lottoCount = LottoCount.of(3, 2);
        assertThat(lottoCount.getAuto()).isEqualTo(3);
        assertThat(lottoCount.getManual()).isEqualTo(2);
    }

    @Test
    void 로또구매_횟수_실패() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> LottoCount.of(2,-1)
        );

        assertThatIllegalArgumentException().isThrownBy(
                () -> LottoCount.of(-2,3)
        );
    }

}
