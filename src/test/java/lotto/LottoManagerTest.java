package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

public class LottoManagerTest {

    private Lotto lotto = new Lotto(
        () -> Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
            new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

    @Test
    public void calculateReturnRate() {
        //given
        Lottos lottos = new Lottos(Arrays.asList(lotto));
        LottoManager lottoManager = new LottoManager();
        WinningLotto winningLotto = new WinningLotto(lotto, new LottoNumber(45));
        lottoManager.makeWinningLotto(winningLotto, lottos);
        double expectedReturnRate = 2_000_000;

        //when
        double actualReturnRate = lottoManager.calculateRateOfReturn(1_000);

        //then
        assertThat(actualReturnRate).isEqualTo(expectedReturnRate);

    }
}