package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {
    @Test
    public void 로또_그룹_생성() {
        Lottos lottos = LottoShop.generateLottos(5);
        assertThat(lottos.getLottoList().size()).isEqualTo(5);
    }

    @Test
    public void 로또_매치() {
        String[] input = new String[2];
        input[0] = "1,2,3,4,5,6";
        input[1] = "1,2,3,7,8,9";
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(LottoFactory.manualGenerator(input[0]));
        lottoList.add(LottoFactory.manualGenerator(input[1]));
        Lottos lottos = new Lottos(lottoList);
        Lotto winningLotto = LottoFactory.manualGenerator(input[0]);
        List<LottoStatistic> list = lottos.matchLottoStatic(winningLotto);
        assertThat(list.get(0)).isEqualTo(LottoStatistic.valueOf(6));
        assertThat(list.get(1)).isEqualTo(LottoStatistic.valueOf(3));
    }
}
