package lotto;

import lotto.domain.LottoStatic;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStaticTest {
    @Test
    public void calculatorCount() {
        LottoStatic lottoStatic = new LottoStatic();
        lottoStatic.calculatorCount(3);
        lottoStatic.calculatorCount(4);
        lottoStatic.calculatorCount(5);
        lottoStatic.calculatorCount(6);
        LottoStatic targetLottoStatic = new LottoStatic(1, 1, 1, 1);
        assertThat(lottoStatic.equals(targetLottoStatic)).isEqualTo(true);
    }

    @Test
    public void calculatorProfitLate() {
        LottoStatic lottoStatic = new LottoStatic();
        lottoStatic.calculatorCount(3);
        lottoStatic.calculatorProfitLate(14000);
        assertThat(lottoStatic.getProfitLate()).isEqualTo(0.35);
    }
}
