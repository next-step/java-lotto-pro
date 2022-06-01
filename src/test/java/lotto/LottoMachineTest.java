package lotto;

import lotto.domain.Lottos;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @ParameterizedTest
    @ValueSource(ints = {1000, 1500, 2000, 2500, 3000})
    void purchaseTest01(int inputMoney) {
        int expectedGameCount = inputMoney / 1000;
        Lottos lottos = lottoMachine.purchase(0, expectedGameCount);

        assertThat(lottos.gameCount())
                .isEqualTo(expectedGameCount);
    }
}