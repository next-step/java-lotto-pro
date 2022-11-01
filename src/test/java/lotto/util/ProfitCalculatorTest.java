package lotto.util;

import lotto.constants.Rank;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitCalculatorTest {

    @Test
    @DisplayName("수익률 계산 테스트 (1개 구매, 3개적중한 로또 1개)")
    public void calculateProfitRatio() {
        int lottoAmount = 1;
        HashMap<Rank, Integer> lottoResultMap = new HashMap<>();
        lottoResultMap.put(Rank.FIFTH, 1);
        LottoResult lottoResult = new LottoResult(lottoResultMap);
        double actualProfitRatio = ProfitCalculator.calculateProfit(lottoResult, lottoAmount);
        double expected = Math.floor(5.0);
        assertThat(actualProfitRatio).isEqualTo(expected);
    }
}