package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static lotto.WinningResult.WIN_FOURTH;
import static lotto.WinningResult.WIN_SECOND;
import static lotto.WinningResult.WIN_THIRD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.ParameterizedTest.DEFAULT_DISPLAY_NAME;

@DisplayName("당첨 결과 목록 테스트")
class WinningResultBagTest {

    private static final int LOTTO_PRICE = 1000;

    @ParameterizedTest(name = "목록 제공 " + DEFAULT_DISPLAY_NAME)
    @CsvSource(value = { "WIN_FOURTH:1", "WIN_THIRD:1", "WIN_SECOND:1" }, delimiter = ':')
    void groupByWinningResult_results_success(WinningResult winningResult, long matchCount) {
        //given:
        WinningResultBag resultBag = new WinningResultBag(Arrays.asList(WIN_FOURTH, WIN_THIRD, WIN_SECOND));
        //when then:
        assertThat(resultBag.groupByWinningResult().get(winningResult)).isEqualTo(matchCount);
    }

    @DisplayName("수익률 제공")
    @Test
    void calculateProfitRate_results_success() {
        //given:
        List<WinningResult> winningResultList = Arrays.asList(WIN_FOURTH, WIN_THIRD, WIN_SECOND);
        double result =
                (double) (WIN_FOURTH.getWinningPrice() + WIN_THIRD.getWinningPrice() + WIN_SECOND.getWinningPrice()) /
                        (LOTTO_PRICE * winningResultList.size());
        //when:
        WinningResultBag resultBag = new WinningResultBag(winningResultList);
        //then:
        assertThat(resultBag.calculateProfitRate()).isEqualTo(result);
    }
}
