package study.step3.models;

import org.junit.jupiter.api.Test;
import study.step3.Rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void 당첨_확인하기() {
        Numbers winLottoNumbers = new Numbers(Arrays.asList(4, 5, 6, 7, 8, 9));
        List<Lotto> lottoList = new ArrayList<>(
                Arrays.asList(
                        new Lotto(new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                        new Lotto(new Numbers(Arrays.asList(2, 3, 4, 5, 6, 7))),
                        new Lotto(new Numbers(Arrays.asList(3, 4, 5, 6, 7, 8)))));
        Lottos lottos = new Lottos(lottoList);
        List<Lotto> rankedLottoList = lottos.rankLottos(winLottoNumbers);

        Winners winners = new Winners(rankedLottoList);

        assertThat(winners.numberOfRankers(Rank.FOURTH)).isEqualTo(1);
        assertThat(winners.numberOfRankers(Rank.THIRD)).isEqualTo(1);
        assertThat(winners.numberOfRankers(Rank.SECOND)).isEqualTo(1);
    }
}
