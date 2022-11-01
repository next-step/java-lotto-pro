package study.step4.models;

import org.junit.jupiter.api.Test;
import study.step3.models.Lotto;
import study.step3.models.Lottos;
import study.step3.models.Money;
import study.step3.models.Numbers;
import study.step3.models.Winners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static study.step3.constants.CommonConstants.PRICE_PER_LOTTO;

public class WinnersTest {
    @Test
    void 수익률_계산하기() {
        Numbers winLottoNumbers = new Numbers(Arrays.asList(4, 5, 6, 7, 8, 9));
        List<Lotto> lottoList = new ArrayList<>(
                Arrays.asList(
                        new Lotto(new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                        new Lotto(new Numbers(Arrays.asList(2, 3, 4, 5, 6, 7))),
                        new Lotto(new Numbers(Arrays.asList(3, 4, 5, 6, 7, 8)))));
        Lottos lottos = new Lottos(lottoList);
        List<Lotto> rankedLottoList = lottos.rankLottos(winLottoNumbers);

        Winners winners = new Winners(rankedLottoList);
        Money inputMoney = new Money(String.valueOf(lottoList.size() * PRICE_PER_LOTTO));
        double earningRate = winners.earningRate(inputMoney);

        // 총 상금 예상 금액 1555000
        assertThat(earningRate).isEqualTo(inputMoney.divide(1555000));
    }
}
