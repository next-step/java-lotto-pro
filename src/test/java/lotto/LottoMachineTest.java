package lotto;

import lotto.domain.Lottos;
import lotto.domain.vo.AutoGameCount;
import lotto.domain.vo.ManualGameCount;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @ParameterizedTest
    @ValueSource(ints = {1000, 1500, 2000, 2500, 3000})
    void purchaseTest01(int inputMoney) {
        int expectedGameCount = inputMoney / 1000;
        ManualGameCount manualGameCount = new ManualGameCount(0, 0);
        AutoGameCount autoGameCount = new AutoGameCount(manualGameCount, inputMoney);
        Lottos lottos = lottoMachine.purchase(manualGameCount, autoGameCount);

        assertThat(lottos.gameCount())
                .isEqualTo(expectedGameCount);
    }
}