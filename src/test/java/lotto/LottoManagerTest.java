package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

public class LottoManagerTest {

    private Lotto lotto = new Lotto(
        () -> List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
            new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

    @Test
    public void calculateReturnRate() {
        Lottos lottos = new Lottos(List.of(lotto));

        LottoManager lottoManager = new LottoManager(lottos);

        lottoManager.makeWinningLotto(lotto);
        lottoManager.calculateRateOfReturn(1000);

        assertThat(lottoManager.calculateRateOfReturn(20000)).isEqualTo(100000);

    }
}
