package study.step4.models;

import org.junit.jupiter.api.Test;
import study.step4.Rank;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void 당첨_확인하기() {
        Lotto winLottoNumbers = new Lotto("4, 5, 6, 7, 8, 9");
        Lottos lottos = new Lottos(
                Arrays.asList(
                        new Lotto("1, 2, 3, 4, 5, 6"),
                        new Lotto("2, 3, 4, 5, 6, 7"),
                        new Lotto("3, 4, 5, 6, 7, 8")));

        Winners winners = lottos.findWinners(winLottoNumbers);

        assertThat(winners.numberOfRankers(Rank.FOURTH)).isEqualTo(1);
        assertThat(winners.numberOfRankers(Rank.THIRD)).isEqualTo(1);
        assertThat(winners.numberOfRankers(Rank.SECOND)).isEqualTo(1);
    }
}
