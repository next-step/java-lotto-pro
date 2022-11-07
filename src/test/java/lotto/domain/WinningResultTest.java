package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {

    @DisplayName("당첨결과 집계 테스트입니다.")
    @ParameterizedTest
    @CsvSource(value = {"14000:0.35714285714285715"
            , "5000:1.00"
            , "7000:0.7142857142857143"
    }, delimiter = ':')
    void 당첨결과집계_5등(int purchaseAmount, double yield) {
        WinningResult result = new WinningResult();
        result.addRank(WinningLottoRank.FIFTH);

        assertThat(result.reportYield(new PurchaseAmount(purchaseAmount))).isEqualTo(yield);
    }

    @DisplayName("당첨결과 집계 테스트입니다.")
    @ParameterizedTest
    @CsvSource(value = {"2000:2000000.00"}, delimiter = ':')
    void 당첨결과집계_1등_2개당첨(int purchaseAmount, double yield) {
        WinningResult result = new WinningResult();
        result.addRank(WinningLottoRank.FIRST);
        result.addRank(WinningLottoRank.FIRST);

        assertThat(result.reportYield(new PurchaseAmount(purchaseAmount))).isEqualTo(yield);
    }
}
