package lotto.domain;

import lotto.constants.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("수익률 계산 테스트 (1개 구매, 3개적중한 로또 1개)")
    public void lottoResultTest() {
        int lottoAmount = 1;
        HashMap<Rank, Integer> lottoResultMap = new HashMap<>();
        lottoResultMap.put(Rank.FIFTH, 1);
        BigDecimal expected = BigDecimal.valueOf(5.0);
        assertThat(new LottoResult(lottoResultMap)
                .calculateProfitRatio(lottoAmount)
                .compareTo(expected) == 0).isTrue();
    }

    @Test
    @DisplayName("수익률 계산 테스트 (2개 구매, 6개적중한 로또 2개)")
    public void calculateProfitRatioBigDecimalTest() {
        int lottoAmount = 2;
        HashMap<Rank, Integer> lottoResultMap = new HashMap<>();
        lottoResultMap.put(Rank.FIRST, 2);
        BigDecimal expected = new BigDecimal("2000000");
        assertThat(new LottoResult(lottoResultMap)
                .calculateProfitRatio(lottoAmount)
                .compareTo(expected) == 0).isTrue();
    }

}