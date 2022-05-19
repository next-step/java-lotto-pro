package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoStatistic;
import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {
    @Test
    public void 로또_그룹_생성_후_출력() {
        Lottos lottos = new Lottos();
        lottos.autoGenerator(5);
        assertThat(lottos.getLottoList().size()).isEqualTo(5);
    }

    @Test
    public void 로또_매치() {
        Lottos lottos = new Lottos();
        String[] input = new String[2];
        input[0] = "1,2,3,4,5,6";
        input[1] = "1,2,3,7,8,9";
        lottos.manualGenerator(input);
        Lotto winningLotto = LottoFactory.manualGenerator(input[0]);
        List<LottoStatistic> list = lottos.matchLottoStatic(winningLotto);
        assertThat(list.get(0)).isEqualTo(LottoStatistic.valueOf(6));
        assertThat(list.get(1)).isEqualTo(LottoStatistic.valueOf(3));
    }
}
