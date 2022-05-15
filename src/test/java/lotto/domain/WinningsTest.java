package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨상금에 대한 테스트")
class WinningsTest {

    @DisplayName("당첨스코어를 전달하면 스코어의 당첨상금의 합이 반환되어야 한다")
    @Test
    void z(LottoWinnings input) {
        LottoScore lottoScore = new LottoScore();
        lottoScore.addScore(LottoWinnings.THREE);
        lottoScore.addScore(LottoWinnings.FOUR);
        lottoScore.addScore(LottoWinnings.ALL);

        Winnings winnings = new Winnings(lottoScore);

        int expected = LottoWinnings.THREE.getWinnings() + LottoWinnings.FOUR.getWinnings() + LottoWinnings.ALL.getWinnings();
        assertThat(winnings.getWinningsPrice()).isEqualTo(expected);
    }
}
