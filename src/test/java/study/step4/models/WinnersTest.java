package study.step4.models;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static study.step3.constants.CommonConstants.PRICE_PER_LOTTO;

public class WinnersTest {
    @Test
    void 수익률_계산하기() {
        WinningLotto winningLotto = new WinningLotto("4, 5, 6, 7, 8, 9");
        Lottos lottos = new Lottos(
                Arrays.asList(
                        new Lotto("1, 2, 3, 4, 5, 6"),
                        new Lotto("2, 3, 4, 5, 6, 7"),
                        new Lotto("3, 4, 5, 6, 7, 8")));
        BonusBall bonusBall = new BonusBall(new LottoNumber(10));
        Winners winners = lottos.findWinners(winningLotto, bonusBall);

        Money inputMoney = new Money(String.valueOf(lottos.size() * PRICE_PER_LOTTO));
        double earningRate = winners.earningRate(inputMoney);

        // 총 상금 예상 금액
        int expectedReward = Rank.FIFTH.getReward() + Rank.FOURTH.getReward() + Rank.THIRD.getReward();
        assertThat(earningRate).isEqualTo(inputMoney.divide(expectedReward));
    }
}
