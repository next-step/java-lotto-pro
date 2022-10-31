package step4.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.util.StringUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또_당첨_통계_클래스")
public class LottoWinningStatisticsTest {
    Map<Rank, Integer> expectedData;

    @BeforeEach
    void before() {
        expectedData = new LinkedHashMap<>();
        expectedData.put(Rank.MISS, 0);
        expectedData.put(Rank.FIFTH, 0);
        expectedData.put(Rank.FOURTH, 0);
        expectedData.put(Rank.THIRD, 0);
        expectedData.put(Rank.SECOND, 0);
        expectedData.put(Rank.FIRST, 0);
    }

    @DisplayName("로또_통계_정상")
    @Test
    void LottoWinningStatistics_pass_01() {

        List<LottoResult> lottoResults = new ArrayList<>();
        lottoResults.add(new LottoResult(new String[]{"1", "2", "3", "4", "5", "6"}));
        LottoResult winLottoResult = new LottoResult(new String[]{"1", "2", "3", "4", "5", "6"});
        LottoNumber bonusLottoNumber = new LottoNumber(7);
        assertThatNoException().isThrownBy(() -> new LottoWinningStatistics(lottoResults, winLottoResult, bonusLottoNumber));
    }

    @DisplayName("로또_통계_정상적으로_통계_생성")
    @ParameterizedTest
    @CsvSource(
            value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:SECOND", "1,2,3,4,5,8:THIRD", "1,2,3,4,8,9:FOURTH",
                    "1,2,3,7,8,9:FIFTH", "1,2,7,8,9,10:MISS", "1,2,7,8,9,10:MISS", "1,11,7,8,9,10:MISS", "12,11,7,8,9,10:MISS", "12,11,13,8,9,10:MISS"}, delimiter = ':'
    )
    void LottoWinningStatistics_pass_02(String lottoResultText, String rankName) {
        LottoResult winLottoResult = new LottoResult(new String[]{"1", "2", "3", "4", "5", "6"});
        LottoNumber bonusLottoNumber = new LottoNumber(7);
        List<LottoResult> lottoResults = new ArrayList<>();
        lottoResults.add(new LottoResult(StringUtil.parseLottoText(lottoResultText)));
        expectedData.put(Rank.valueOf(rankName), 1);
        LottoWinningStatistics lottoWinningStatistics = new LottoWinningStatistics(lottoResults, winLottoResult, bonusLottoNumber);
        assertThat(lottoWinningStatistics.getLottoWinningStatistics()).isEqualTo(expectedData);
    }

    @DisplayName("로또_통계_수익률_정상")
    @Test
    void LottoWinningStatistics_totalProfit_pass_01() {
        List<LottoResult> lottoResults = new ArrayList<>();
        lottoResults.add(new LottoResult(new String[]{"1", "2", "3", "4", "5", "6"}));
        LottoResult winLottoResult = new LottoResult(new String[]{"1", "2", "3", "4", "5", "6"});
        LottoNumber bonusLottoNumber = new LottoNumber(7);
        LottoWinningStatistics lottoWinningStatistics = new LottoWinningStatistics(lottoResults, winLottoResult, bonusLottoNumber);
        assertThat(lottoWinningStatistics.getTotalProfitPercent(new Money(1000))).isEqualTo((double) Rank.FIRST.getWinningMoney() / 1000);
    }

    @DisplayName("로또_통계_보너스_번호는_당첨_번호와_중복되면_에러")
    @Test
    void LottoWinningStatistics_valid_winLottoResult_fail_01() {
        List<LottoResult> lottoResults = new ArrayList<>();
        lottoResults.add(new LottoResult(new String[]{"1", "2", "3", "4", "5", "6"}));
        LottoResult winLottoResult = new LottoResult(new String[]{"1", "2", "3", "4", "5", "6"});
        LottoNumber bonusLottoNumber = new LottoNumber(6);
        assertThatThrownBy(
                () -> new LottoWinningStatistics(lottoResults, winLottoResult, bonusLottoNumber)
        ).isInstanceOf(RuntimeException.class);
    }
}
