package lotto;

import lotto.domain.LottoStatistic;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStaticTest {
    @Test
    public void calculatorCount() {
        LottoStatistic lottoStatistic = new LottoStatistic();
        lottoStatistic.calculatorCount(3);
        lottoStatistic.calculatorCount(4);
        lottoStatistic.calculatorCount(5);
        lottoStatistic.calculatorCount(6);
        LottoStatistic targetLottoStatistic = new LottoStatistic(1, 1, 1, 1);
        assertThat(lottoStatistic.equals(targetLottoStatistic)).isEqualTo(true);
    }

    @Test
    public void calculatorProfitLate() {
        LottoStatistic lottoStatistic = new LottoStatistic();
        lottoStatistic.calculatorCount(3);
        lottoStatistic.calculatorProfitLate(14000);
        assertThat(lottoStatistic.getProfitLate()).isEqualTo(0.35);
    }
}
