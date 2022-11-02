package study.step4.models;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static study.step3.constants.CommonConstants.PRICE_PER_LOTTO;

public class WinnersTest {
    @Test
    void 수익률_계산하기() {
        Lotto winLotto = new Lotto("4, 5, 6, 7, 8, 9");
        Lottos lottos = new Lottos(
                Arrays.asList(
                        new Lotto("1, 2, 3, 4, 5, 6"),
                        new Lotto("2, 3, 4, 5, 6, 7"),
                        new Lotto("3, 4, 5, 6, 7, 8")));
        Winners winners = lottos.findWinners(winLotto);

        Money inputMoney = new Money(String.valueOf(lottos.size() * PRICE_PER_LOTTO));
        double earningRate = winners.earningRate(inputMoney);

        // 총 상금 예상 금액 1555000
        assertThat(earningRate).isEqualTo(inputMoney.divide(1555000));
    }
}
