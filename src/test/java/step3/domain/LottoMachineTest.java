package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @DisplayName("로또 발급 테스트")
    @Test
    void 로또발급테스트() {
        LottoCreateStrategy strategy = new AutoLottoCreateStrategy();
        assertThat(LottoMachine.getLotto(strategy)).isInstanceOf(Lotto.class);
        assertThat(LottoMachine.getLotto(strategy)).isInstanceOf(Lotto.class);
        assertThat(LottoMachine.getLotto(strategy)).isInstanceOf(Lotto.class);
        assertThat(LottoMachine.getLotto(strategy)).isInstanceOf(Lotto.class);
        assertThat(LottoMachine.getLotto(strategy)).isInstanceOf(Lotto.class);
        assertThat(LottoMachine.getLotto(strategy)).isInstanceOf(Lotto.class);
    }
}
