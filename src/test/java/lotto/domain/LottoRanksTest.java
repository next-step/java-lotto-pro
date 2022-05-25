package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoRanksTest {
    private static LottoRanks lottoResult; // 당첨결과: 4등 1회, 5등 2회

    @BeforeAll
    static void initialize() {
        List<LottoRank> lottoRanks = new ArrayList<>();
        lottoRanks.add(LottoRank.FIFTH);
        lottoRanks.add(LottoRank.FIFTH);
        lottoRanks.add(LottoRank.FOURTH);
        lottoResult = new LottoRanks(lottoRanks);
    }

    @Test
    @DisplayName("당첨 상금 총합을 계산한다.")
    void checkLottoAccPrize() {
        assertThat(lottoResult.prize()).isEqualTo(60000);
    }

    @Test
    @DisplayName("당첨 횟수를 계산한다.")
    void checkLottoMatchRank() {
        assertAll(
            () -> assertThat(lottoResult.matchRank(LottoRank.FIRST)).isEqualTo(0),
            () -> assertThat(lottoResult.matchRank(LottoRank.SECOND)).isEqualTo(0),
            () -> assertThat(lottoResult.matchRank(LottoRank.THIRD)).isEqualTo(0),
            () -> assertThat(lottoResult.matchRank(LottoRank.FOURTH)).isEqualTo(1),
            () -> assertThat(lottoResult.matchRank(LottoRank.FIFTH)).isEqualTo(2)
        );
    }
}