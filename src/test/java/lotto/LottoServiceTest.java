package lotto;

import lotto.service.LottoServiceCalculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {

    @Test
    void 로또_개수_계산() {
        assertThat(LottoServiceCalculator.getLottoCount(14000)).isEqualTo(14);
    }

    @Test
    void 총_수익률_계산() {
        assertThat(LottoServiceCalculator.calculateProfitRate(5000, 14000)).isEqualTo(0.35);
    }
}