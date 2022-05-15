package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.Money;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    void 로또_개수에_맞게_로또를_발급한다() {
        // when
        Lottos buy = LottoMachine.buy(Money.of(3000));
        // then
        assertThat(buy.count()).isEqualTo(3);
    }
}