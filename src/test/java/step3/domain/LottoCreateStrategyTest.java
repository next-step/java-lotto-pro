package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCreateStrategyTest {

    @DisplayName("로또 자동발급 전략패턴 인터페이스 적용")
    @Test
    void 로또_자동발급_전략패턴_적용() {
        LottoCreateStrategy strategy = new AutoLottoCreateStrategy();
        Lotto lotto = LottoMachine.getLotto(strategy);

        assertThat(lotto).isInstanceOf(Lotto.class);
        assertThat(lotto.lottoNumbers).hasSize(6);
    }
}
