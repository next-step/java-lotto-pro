package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {

    @DisplayName("당첨결과 집계 테스트입니다.")
    @ParameterizedTest
    @CsvSource(value = {"14000:0.35714285714285715"
            ,"5000:1.00"
            ,"7000:0.7142857142857143"
    }, delimiter = ':')
    void 당첨결과집계(int purchaseAmount, double yield) {
        WinningResult result = new WinningResult();
        result.addRank(WinningLottoRank.FIFTH);

        assertThat(result.reportYield(new PurchaseAmount(purchaseAmount))).isEqualTo(yield);
    }
}
