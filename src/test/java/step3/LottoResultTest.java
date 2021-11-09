package step3;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step3.domain.Amount;
import step3.domain.LottoRanks;

public class LottoResultTest {

    @ParameterizedTest
    @CsvSource(value = {
        "1000000:6:false:2000.00",
        "600000:5:true:50.00", // 2등 보너스
        "400000:5:false:3.75",
        "500000:4:false:0.10",
        "50000:3:true:0.10",
        "5000:0:true:0.00",
    }, delimiter = ':')
    @DisplayName("LottoRank 랭킹별 수익률 테스트")
    void getCalculatedYield_수익률_테스트(int money, int matchCount, boolean isContainBonus, BigDecimal expected) {
        // given
        Amount amount = new Amount(money);
        LottoRanks lottoRanks = new LottoRanks();
        lottoRanks.matchIncrementCount(matchCount, isContainBonus);

        // when
        BigDecimal yield = lottoRanks.getCalculatedYield(amount);

        // then
        assertThat(yield).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "5:6:false:2001500000", // 1등, 3등
        "5:6:true:2030000000",  // 1등, 2등
        "5:5:true:60000000",    // 2등, 2등
        "5:5:false:3000000",    // 3등, 3등
        "3:0:true:5000",        // 5등, 당첨없음
        "2:0:false:0",          // 당첨없음, 당첨없음
        "0:0:false:0",          // 당첨없음 당첨없음
    }, delimiter = ':')
    @DisplayName("다중 당첨시 총 상금 테스트")
    void getTotalPrize_다중_당첨(int matchCount1, int matchCount2, boolean isContainBonus, Long expected) {
        // given
        Amount amount = new Amount(10000);
        LottoRanks lottoRanks = new LottoRanks();

        // when
        lottoRanks.matchIncrementCount(matchCount1, isContainBonus);
        lottoRanks.matchIncrementCount(matchCount2, isContainBonus);
        Long totalPrize = lottoRanks.totalPrize();

        // then
        assertThat(totalPrize).isEqualTo(expected);
    }
}
