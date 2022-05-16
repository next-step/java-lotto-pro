package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("당첨상금에 대한 테스트")
class WinningsTest {

    @DisplayName("당첨스코어를 전달하면 스코어의 당첨상금의 합이 반환되어야 한다")
    @Test
    void winnings_test() {
        LottoScore lottoScore = new LottoScore();
        lottoScore.addScore(LottoWinnings.THREE);
        lottoScore.addScore(LottoWinnings.FOUR);
        lottoScore.addScore(LottoWinnings.ALL);

        Winnings winnings = lottoScore.getWinnings();

        int expected = LottoWinnings.THREE.getWinnings() + LottoWinnings.FOUR.getWinnings() + LottoWinnings.ALL.getWinnings();
        assertThat(winnings.getWinningsPrice()).isEqualTo(expected);
    }

    @DisplayName("당첨상금에 대해 정확한 수익률이 계산 되어야 한다")
    @ParameterizedTest
    @CsvSource(value = {"5000,14000:0.35", "2000,6000:0.33", "30000,5000:6"}, delimiter = ':')
    void profit_rate_test(String input, double rate) {
        String[] inputs = input.split(",");

        Winnings winnings = new Winnings(Integer.parseInt(inputs[0]));

        int 구매금액 = Integer.parseInt(inputs[1]);
        winnings.profitRate(구매금액);
        assertThat(winnings.profitRate(구매금액)).isEqualTo(rate);
    }
}
