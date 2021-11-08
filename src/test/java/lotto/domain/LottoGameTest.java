package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoGameTest {

    @DisplayName("통계 결과 조회")
    @Test
    void getStatistics() {
        LottoGame lottoGame = new LottoGame(
                Arrays.asList(
                        new LottoBalls("1,2,3,4,5,6"),
                        new LottoBalls("1,2,3,4,5,10"),
                        new LottoBalls("1,2,3,4,5,7"),
                        new LottoBalls("1,2,3,4,7,8"),
                        new LottoBalls("1,2,3,4,7,8")
                )
        );
        LottoBall bonusBall = new LottoBall(10);
        LottoBalls winBalls = new LottoBalls("1,2,3,4,5,6");
        WinningBalls winningBalls = new WinningBalls(winBalls, bonusBall);

        Statistics statistics = lottoGame.calculateLottoResult(winningBalls);
        assertAll(
                () -> assertThat(statistics.getCount(Ranking.FIRST)).isEqualTo(1),
                () -> assertThat(statistics.getCount(Ranking.SECOND_BONUS)).isEqualTo(1),
                () -> assertThat(statistics.getCount(Ranking.SECOND)).isEqualTo(1),
                () -> assertThat(statistics.getCount(Ranking.THIRD)).isEqualTo(2),
                () -> assertThat(statistics.getCount(Ranking.FOURTH)).isEqualTo(0)
        );

    }

}
