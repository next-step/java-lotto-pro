package lotto.util;

import lotto.constants.Rank;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitCalculatorTest {

    @Test
    @DisplayName("수익률 계산 테스트 (1개 구매, 3개적중한 로또 1개)")
    public void calculateProfitRatioTest() {
        int lottoAmount = 1;
        HashMap<Rank, Integer> lottoResultMap = new HashMap<>();
        lottoResultMap.put(Rank.FIFTH, 1);
        LottoResult lottoResult = new LottoResult(lottoResultMap);
        BigDecimal actualProfitRatio = ProfitCalculator.calculateProfitRatio(lottoResult, lottoAmount);
        BigDecimal expected = BigDecimal.valueOf(5.0);
        assertThat(actualProfitRatio.compareTo(expected) == 0).isTrue();
    }

    @Test
    @DisplayName("수익률 계산 테스트 (2개 구매, 6개적중한 로또 2개)")
    public void calculateProfitRatioBigDecimalTest() {
        int lottoAmount = 2;
        HashMap<Rank, Integer> lottoResultMap = new HashMap<>();
        lottoResultMap.put(Rank.FIRST, 2);
        LottoResult lottoResult = new LottoResult(lottoResultMap);
        BigDecimal actualProfitRatio = ProfitCalculator.calculateProfitRatio(lottoResult, lottoAmount);
        BigDecimal expected = new BigDecimal("2000000");
        assertThat(actualProfitRatio.compareTo(expected) == 0).isTrue();
    }
}