package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.ParameterizedTest.DEFAULT_DISPLAY_NAME;

@DisplayName("당첨 결과 테스트")
class WinningResultTest {

    @ParameterizedTest(name = "당첨 결과 제공 테스트 " + DEFAULT_DISPLAY_NAME)
    @CsvSource(value = { "0:NOT_MATCH", "1:MATCH_ONE", "2:MATCH_TWO",
            "3:WIN_FOURTH", "4:WIN_THIRD", "5:WIN_SECOND", "6:WIN_FIRST" }, delimiter = ':')
    void getResultByMatchScore_winningRedsult_success(int matchCount, WinningResult winningResult) {
        assertThat(WinningResult.getResultByMatchScore(Score.of(matchCount))).isEqualTo(winningResult);
    }
}
