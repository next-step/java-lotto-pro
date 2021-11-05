package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoResultTest {

    @DisplayName("로또 결과 확인")
    @ParameterizedTest
    @CsvSource(value = {"3,THREE", "4,FOUR", "5,FIVE", "6,SIX", "0,NONE", "2,NONE"})
    void findResult_success(int cnt, String resultName) {
        assertThat(LottoResult.findResult(cnt)).isEqualTo(LottoResult.valueOf(resultName));
    }

    @DisplayName("로또 결과 확인")
    @ParameterizedTest
    @CsvSource(value = {"THREE,10000", "FOUR, 100000", "FIVE,3000000", "SIX,4000000000", "NONE,0"})
    void calculatePrize_success(String resultName, long prize) {
        assertThat(LottoResult.valueOf(resultName).calculateMultiplePrize(2)).isEqualTo(new LottoPrize(prize));
    }
}