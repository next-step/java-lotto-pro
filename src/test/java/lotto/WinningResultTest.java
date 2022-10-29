package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.ParameterizedTest.DEFAULT_DISPLAY_NAME;

class WinningResultTest {

    @ParameterizedTest(name = "당첨 결과 제공 기능 테스트 " + DEFAULT_DISPLAY_NAME)
    @CsvSource(value = { "0:NOT_MATCH", "1:MATCH_ONE", "2:MATCH_TWO",
            "3:MATCH_THREE", "4:MATCH_FOUR", "5:MATCH_FIVE", "6:MATCH_SIX" }, delimiter = ':')
    void getResultByMatchCount_winningRedsult_success(int matchCount, WinningResult winningResult) {
        assertThat(WinningResult.getResultByMatchCount(matchCount)).isEqualTo(winningResult);
    }
}
