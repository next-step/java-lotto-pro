package study.step3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static study.step3.constants.CommonConstants.PRICE_PER_LOTTO;

public class WinnersTest {
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
        Money inputMoney = new Money(String.valueOf(lottoList.size() * PRICE_PER_LOTTO));
        double earningRate = winners.earningRate(inputMoney);

        // 총 상금 예상 금액 1555000
        assertThat(earningRate).isEqualTo(inputMoney.divide(1555000));
    }
}
