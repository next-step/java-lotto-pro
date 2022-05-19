package lotto;

import lotto.controller.LottoCount;
import lotto.domain.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    void 자동_로또_generator를_인자로_받아_로또를_산다() {
        // given
        LottoMachine lottoMachine = new LottoMachine();
        LottoGenerator autoLottoGenerator = new AutoLottoGenerator(new LottoCount(3));
        // when
        Lottos result = lottoMachine.buy(autoLottoGenerator);
        // then
        assertThat(result.count()).isEqualTo(3);
    }
}