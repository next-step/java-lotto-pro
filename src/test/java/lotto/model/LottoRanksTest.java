package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.constants.LottoConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRanksTest {
    private List<LottoRank> lottoRankList;
    private LottoRanks lottoRanks;

    @BeforeEach
    void setUp() {
        lottoRankList = Arrays.asList(LottoRank.FIRST, LottoRank.SECOND, LottoRank.MISS, LottoRank.FIRST);
        lottoRanks = LottoRanks.of(lottoRankList);
    }

    @Test
    @DisplayName("입력 받은 로또 등급들을 설정")
    void setLottoRanks() {
        assertThat(lottoRanks).isNotNull();
    }

    @Test
    @DisplayName("입력 받은 로또 등급들을 결과 반환")
    void getResultLottoRanks() {
        Map<LottoRank, Long> result = lottoRanks.resultLottoRanks();

        assertAll(
                () -> assertEquals(2, result.get(LottoRank.FIRST)),
                () -> assertEquals(1, result.get(LottoRank.SECOND)),
                () -> assertEquals(1, result.get(LottoRank.MISS))
        );
    }

    @Test
    @DisplayName("수익률이 일치하는지 확인")
    void verifyTotalCashPrize() {
        double profitRate = lottoRanks.getProfitRate();

        long totalCashPrize = lottoRankList.stream()
                .mapToLong(LottoRank::getCashPrize)
                .sum();
        int purchaseAmount = lottoRankList.size() * LottoConstant.LOTTO_PRICE;

        assertEquals((double) totalCashPrize / purchaseAmount, profitRate);
    }
}
