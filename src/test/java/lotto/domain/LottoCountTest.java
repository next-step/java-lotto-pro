package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoCountTest {

    @Test
    void 로또구매_횟수_생성() {
        LottoCount lottoCount = LottoCount.of(Money.from(5000), 2);
        assertThat(lottoCount.getAuto()).isEqualTo(3);
        assertThat(lottoCount.getManual()).isEqualTo(2);
    }

    @Test
    void 수동로또구매_횟수_실패_음수() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> LottoCount.of(Money.from(5000), -1)
        ).withMessageContaining("구매횟수 음수가 될 수 없습니다.");
    }

    @Test
    void 로또구매_횟수_실패_구입금액초과() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> LottoCount.of(Money.from(5000), 9)
        ).withMessageContaining("구입금액보다 많은 로또를 수동으로 구매할 수 없습니다.");
    }
}
