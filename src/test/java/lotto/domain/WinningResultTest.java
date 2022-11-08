package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {

    @DisplayName("당첨결과 집계 테스트입니다.")
    @Test
    void 당첨결과집계_5등() {
        WinningResult result = new WinningResult();
        result.addRank(WinningLottoRank.FIFTH);
        result.addRank(WinningLottoRank.MISS);
        result.addRank(WinningLottoRank.MISS);
        result.addRank(WinningLottoRank.MISS);
        result.addRank(WinningLottoRank.MISS);
        result.addRank(WinningLottoRank.MISS);
        result.addRank(WinningLottoRank.MISS);
        result.addRank(WinningLottoRank.MISS);
        result.addRank(WinningLottoRank.MISS);
        result.addRank(WinningLottoRank.MISS);
        result.addRank(WinningLottoRank.MISS);
        result.addRank(WinningLottoRank.MISS);
        result.addRank(WinningLottoRank.MISS);
        result.addRank(WinningLottoRank.MISS);

        assertThat(result.reportYield()).isEqualTo(0.35714285714285715);
    }

    @DisplayName("당첨결과 집계 테스트입니다.")
    @Test
    void 당첨결과집계_1등_2개당첨() {
        WinningResult result = new WinningResult();
        result.addRank(WinningLottoRank.FIRST);
        result.addRank(WinningLottoRank.FIRST);

        assertThat(result.reportYield()).isEqualTo(2000000.00);
    }
}
