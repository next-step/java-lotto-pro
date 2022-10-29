package study.step3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    @Test
    void 당첨_확인하기() {
        Lotto winLotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
        List<Lotto> lottoList = new ArrayList<>(
                Arrays.asList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)),
                        new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8))));
        Lottos lottos = new Lottos(lottoList);

        Winners winners = lottos.findWinners(winLotto);

        assertThat(winners.nThPrizeSize(3)).isEqualTo(1);
        assertThat(winners.nThPrizeSize(4)).isEqualTo(1);
        assertThat(winners.nThPrizeSize(5)).isEqualTo(1);
    }

    @Test
    void 수익률_계산하기() {
        Lotto winLotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
        List<Lotto> lottoList = new ArrayList<>(
                Arrays.asList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)),
                        new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8))));
        Lottos lottos = new Lottos(lottoList);

        Winners winners = lottos.findWinners(winLotto);
        int inputMoney = lottoList.size() * Lottos.PRICE_PER_LOTTO;
        double earningRate = winners.earningRate(inputMoney);

        // 총 상금 예상 금액 1555000
        assertThat(earningRate).isEqualTo((double) 1555000 / inputMoney);
    }
}
