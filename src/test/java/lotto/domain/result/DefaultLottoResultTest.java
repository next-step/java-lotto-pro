package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.matcher.count.MatchCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DefaultLottoResultTest {


    @ParameterizedTest
    @DisplayName("보너스볼을 맞추지 못했을때 총 수익을 계산한다")
    @CsvSource(value = {"3:5000:false", "4:50000:false", "5:1500000:false", "6:2000000000:false"}, delimiter = ':')
    void totalProfit_bonus_false(int matchCount, int expected, boolean isMatchBonus) {
        DefaultLottoResult lottoResult = new DefaultLottoResult();
        LottoResult.THREE.calculateTotalCount(new MatchCount(matchCount, isMatchBonus));
        LottoResult.FOUR.calculateTotalCount(new MatchCount(matchCount, isMatchBonus));
        LottoResult.FIVE.calculateTotalCount(new MatchCount(matchCount, isMatchBonus));
        LottoResult.FIVE_BONUS.calculateTotalCount(new MatchCount(matchCount, isMatchBonus));
        LottoResult.SIX.calculateTotalCount(new MatchCount(matchCount, isMatchBonus));
        assertThat(lottoResult.totalProfit()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("보너스볼을 맞췄을때 총 수익을 계산한다")
    @CsvSource(value = {"3:0:true", "4:5000:true", "5:50000:true", "6:30000000:true"}, delimiter = ':')
    void totalProfit_bonus_true(int matchCount, int expected, boolean isMatchBonus) {
        DefaultLottoResult lottoResult = new DefaultLottoResult();
        LottoResult.THREE.calculateTotalCount(new MatchCount(matchCount, isMatchBonus));
        LottoResult.FOUR.calculateTotalCount(new MatchCount(matchCount, isMatchBonus));
        LottoResult.FIVE.calculateTotalCount(new MatchCount(matchCount, isMatchBonus));
        LottoResult.FIVE_BONUS.calculateTotalCount(new MatchCount(matchCount, isMatchBonus));
        LottoResult.SIX.calculateTotalCount(new MatchCount(matchCount, isMatchBonus));
        assertThat(lottoResult.totalProfit()).isEqualTo(expected);
    }

}
