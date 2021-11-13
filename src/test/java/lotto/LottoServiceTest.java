package lotto;

import lotto.domain.LottoPrize;
import lotto.service.LottoServiceCalculator;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {

    @Test
    void 로또_개수_계산() {
        assertThat(LottoServiceCalculator.getLottoCount(14000)).isEqualTo(14);
    }

    @Test
    void 총_수익률_계산() {
        Map<LottoPrize, Integer> lottoResultMap = new HashMap<>();
        lottoResultMap.put(LottoPrize.FIFTH, 1);
        assertThat(LottoServiceCalculator.calculateProfitRate(lottoResultMap, 14000)).isEqualTo(0.35);
    }
}