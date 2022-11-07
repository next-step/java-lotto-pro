package study.step4.models;

import org.junit.jupiter.api.Test;
import study.step4.Rank;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void 당첨_확인하기() {
        WinningLotto winLottoNumbers = new WinningLotto("4, 5, 6, 7, 8, 9");
        Lottos lottos = new Lottos(
                Arrays.asList(
                        new Lotto("1, 2, 3, 4, 5, 6"),
                        new Lotto("2, 3, 4, 5, 6, 7"),
                        new Lotto("2, 4, 5, 6, 7, 8"),
                        new Lotto("3, 4, 5, 6, 7, 8")));
        BonusBall bonusBall = new BonusBall(new LottoNumber(3));

        Winners winners = lottos.findWinners(winLottoNumbers, bonusBall);

        // 4, 5, 6
        assertThat(winners.numberOfRankers(Rank.FIFTH)).isEqualTo(1);
        // 4, 5, 6, 7
        assertThat(winners.numberOfRankers(Rank.FOURTH)).isEqualTo(1);
        // 4, 5, 6, 7, 8
        assertThat(winners.numberOfRankers(Rank.THIRD)).isEqualTo(1);
        // 4, 5, 6, 7, 8 bonus 3
        assertThat(winners.numberOfRankers(Rank.SECOND)).isEqualTo(1);
    }
}
