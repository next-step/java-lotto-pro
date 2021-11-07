package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @DisplayName("문자열 변환")
    @Test
    void convertString() {
        LottoGame lottoGame = new LottoGame(
                Arrays.asList(
                        new LottoBalls("1,2,3,4,5,6"),
                        new LottoBalls("7,8,9,10,11,12"),
                        new LottoBalls("13,14,15,16,17,18")
                )
        );

        String result = lottoGame.toString();

        assertThat(result).isEqualTo(
                "[1,2,3,4,5,6]\n[7,8,9,10,11,12]\n[13,14,15,16,17,18]\n"
        );
    }

    @DisplayName("1등,2등,3등 통계 결과 조회")
    @Test
    void getStatistics() {
        LottoGame lottoGame = new LottoGame(
                Arrays.asList(
                        new LottoBalls("1,2,3,4,5,6"),
                        new LottoBalls("1,2,3,4,5,7"),
                        new LottoBalls("1,2,3,4,7,8"),
                        new LottoBalls("1,2,3,4,7,8")
                )
        );

        LottoBalls winBalls = new LottoBalls("1,2,3,4,5,6");

        Statistics statistics = lottoGame.calculateLottoResult(winBalls);
        assertThat(statistics.getCount(Ranking.FIRST)).isEqualTo(1);
        assertThat(statistics.getCount(Ranking.SECOND)).isEqualTo(1);
        assertThat(statistics.getCount(Ranking.THIRD)).isEqualTo(2);
        assertThat(statistics.getCount(Ranking.FOURTH)).isEqualTo(0);

    }
}