package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static lotto.WinningResult.MATCH_FIVE;
import static lotto.WinningResult.MATCH_FOUR;
import static lotto.WinningResult.MATCH_THREE;
import static lotto.WinningResultBag.MATCH_FIVE_REWARD;
import static lotto.WinningResultBag.MATCH_FOUR_REWARD;
import static lotto.WinningResultBag.MATCH_THREE_REWARD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.ParameterizedTest.DEFAULT_DISPLAY_NAME;

@DisplayName("당첨 결과 목록 테스트")
class WinningResultBagTest {

    private static final int LOTTO_PRICE = 1000;

    @ParameterizedTest(name = "목록 제공 " + DEFAULT_DISPLAY_NAME)
    @CsvSource(value = { "MATCH_THREE:1", "MATCH_FOUR:1", "MATCH_FIVE:1" }, delimiter = ':')
    void countByWinningResult_results_success(WinningResult winningResult, int matchCount) {
        //given:
        WinningResultBag resultBag = new WinningResultBag(Arrays.asList(MATCH_THREE, MATCH_FOUR, MATCH_FIVE));
        //when then:
        assertThat(resultBag.countByWinningResult(winningResult)).isEqualTo(matchCount);
    }

    @DisplayName("수익률 제공")
    @Test
    void calculateProfitRate_results_success() {
        //given:
        List<WinningResult> winningResultList = Arrays.asList(MATCH_THREE, MATCH_FOUR, MATCH_FIVE);
        double result = (double) (MATCH_THREE_REWARD + MATCH_FOUR_REWARD + MATCH_FIVE_REWARD) /
                (LOTTO_PRICE * winningResultList.size());
        //when:
        WinningResultBag resultBag = new WinningResultBag(winningResultList);
        //then:
        assertThat(resultBag.calculateProfitRate()).isEqualTo(result);
    }
}
