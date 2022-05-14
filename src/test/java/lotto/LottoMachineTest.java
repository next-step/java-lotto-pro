package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    void 로또_개수에_맞게_로또를_발급한다() {
        // when
        Lottos buy = LottoMachine.buy(3000);
        // then
        assertThat(buy.count()).isEqualTo(3);
    }
}