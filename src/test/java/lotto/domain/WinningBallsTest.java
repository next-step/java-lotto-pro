package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningBallsTest {

    @DisplayName("5개 일치하고 보너스볼 일치하면 SECOND_BONUS 반환")
    @Test
    void calculateRankingSecondBonus() {
        LottoBalls winBalls = new LottoBalls("1,2,3,4,5,6");
        LottoBall bonusBall = new LottoBall(10);
        WinningBalls winningBalls = new WinningBalls(winBalls, bonusBall);
        LottoBalls drawBalls = new LottoBalls("1,2,3,4,5,10");

        Ranking ranking = winningBalls.calculateRanking(drawBalls);
        assertThat(ranking).isEqualTo(Ranking.SECOND_BONUS);
    }

}
