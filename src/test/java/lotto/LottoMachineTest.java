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

    @Test
    void 수동_로또_generator를_인자로_받아_로또를_산다() {
        // given
        LottoMachine lottoMachine = new LottoMachine();

        String[] numbers = {"1, 2, 3, 4, 5, 6", "1, 2, 5, 7, 8, 10"};
        LottoGenerator manualLottoGenerator = new ManualLottoGenerator(new ManualLottoNumbers(numbers));
        // when
        Lottos result = lottoMachine.buy(manualLottoGenerator);
        // then
        assertThat(result.count()).isEqualTo(2);
    }
}