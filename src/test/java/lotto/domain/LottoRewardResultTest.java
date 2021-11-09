package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRewardResultTest {

    LottoRewardResult lottoRewardResult;

    @BeforeEach
    void setUp() {
        Map<LottoReward, Integer> lottoRewardMap = new HashMap<>();
        lottoRewardMap.put(LottoReward.FIFTH_PLACE, 1);
        lottoRewardResult = new LottoRewardResult(lottoRewardMap);
    }

    @Test
    void 수익률_조회() {
        // given
        int purchaseMoney = 14000;

        // when
        double result = lottoRewardResult.getRateOfProfit(purchaseMoney);

        // then
        assertThat(result).isGreaterThanOrEqualTo(0.35);
        assertThat(result).isLessThanOrEqualTo(0.36);
    }

    @ParameterizedTest
    @CsvSource(value = {"FIFTH_PLACE:1", "FIRST_PLACE:0"}, delimiter = ':')
    void 주어진_등수에_당첨된_갯수_조회(LottoReward lottoReward, int expectCount) {
        // when
        int result = lottoRewardResult.getWinningLottoTicketCount(lottoReward);

        // then
        assertThat(result).isEqualTo(expectCount);
    }

}