package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DefaultLottoResultTest {

    @ParameterizedTest
    @DisplayName("총 수익을 계산한다")
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    void totalProfit(int matchCount, int expected) {
        DefaultLottoResult lottoResult = new DefaultLottoResult();
        LottoResult.THREE.calculateTotalCount(matchCount);
        LottoResult.FOUR.calculateTotalCount(matchCount);
        LottoResult.FIVE.calculateTotalCount(matchCount);
        LottoResult.SIX.calculateTotalCount(matchCount);
        assertThat(lottoResult.totalProfit()).isEqualTo(expected);
    }

}
