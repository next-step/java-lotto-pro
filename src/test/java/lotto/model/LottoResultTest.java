package lotto.model;

import lotto.util.GameRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("[정상]로또상금 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2:1:1:1"}, delimiter = ':')
    void 로또상금_계산_테스트_정상(int match3, int match4, int match5, int match6) {
        // given
        LottoResult lottoResult = new LottoResult();
        lottoResult.getMatchCounts().put(LottoWinningPrice.THREE, match3);
        lottoResult.getMatchCounts().put(LottoWinningPrice.FOUR, match4);
        lottoResult.getMatchCounts().put(LottoWinningPrice.FIVE, match5);
        lottoResult.getMatchCounts().put(LottoWinningPrice.SIX, match6);

        BigDecimal comReward = new BigDecimal(
                GameRule.MATCH_PRICE_3 * match3
                        + GameRule.MATCH_PRICE_4 * match4
                        + GameRule.MATCH_PRICE_5 * match5
                        + GameRule.MATCH_PRICE_6 * match6);
        // when
        BigDecimal lottoReward = lottoResult.calculateWinningReward();
        // then
        assertThat(lottoReward).isEqualTo(comReward);
    }

    @DisplayName("[정상]로또수익률 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:0:0:0:14000"}, delimiter = ':')
    void 로또수익률_계산_테스트_정상(int match3, int match4, int match5, int match6, long buyPrice) {
        // given
        LottoResult lottoResult = new LottoResult();
        lottoResult.getMatchCounts().put(LottoWinningPrice.THREE, match3);
        lottoResult.getMatchCounts().put(LottoWinningPrice.FOUR, match4);
        lottoResult.getMatchCounts().put(LottoWinningPrice.FIVE, match5);
        lottoResult.getMatchCounts().put(LottoWinningPrice.SIX, match6);
        // when
        lottoResult.calculateYield(buyPrice);
        // then
        assertThat(lottoResult.getYield()).isEqualTo(0.35);
    }

    @DisplayName("[정상]로또상금 계산(보너스) 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:0:0:0:2"}, delimiter = ':')
    void 로또상금_계산__보너스_테스트_정상(int match3, int match4, int match5, int match6, int bonusMatch) {
        // given
        LottoResult lottoResult = new LottoResult();
        lottoResult.getMatchCounts().put(LottoWinningPrice.THREE, match3);
        lottoResult.getMatchCounts().put(LottoWinningPrice.FOUR, match4);
        lottoResult.getMatchCounts().put(LottoWinningPrice.FIVE, match5);
        lottoResult.getMatchCounts().put(LottoWinningPrice.SIX, match6);
        lottoResult.getMatchCounts().put(LottoWinningPrice.BONUS, bonusMatch);

        BigDecimal comReward = new BigDecimal(
                GameRule.MATCH_PRICE_3 * match3
                        + GameRule.MATCH_PRICE_4 * match4
                        + GameRule.MATCH_PRICE_5 * match5
                        + GameRule.MATCH_PRICE_6 * match6
                        + GameRule.MATCH_PRICE_BONUS * bonusMatch);
        // when
        BigDecimal lottoReward = lottoResult.calculateWinningReward();
        // then
        assertThat(lottoReward).isEqualTo(comReward);
    }
}
