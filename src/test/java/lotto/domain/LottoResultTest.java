package lotto.domain;

import lotto.type.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @Test
    @DisplayName("로또등수를 확인한다.")
    void 로또_등수_확인() {
        Lotto lotto1 = new Lotto(new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9)));
        Lotto lotto2 = new Lotto(new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 10)));
        Lotto lotto3 = new Lotto(new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 11)));
        Lotto lotto4 = new Lotto(new HashSet<>(Arrays.asList(4, 5, 6, 7, 12, 13)));
        Lotto lotto5 = new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

        Lotto answerLotto = new Lotto(new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9)));
        answerLotto.addBonusBallNumber(10);

        Lottos lottos = new Lottos(
            Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5)
        );
        Map<Lotto, LottoRank> lottoLottoRankResult1 = lottos.lottoWinningResult(answerLotto);

        LottoRank lottoRank1 = lottoLottoRankResult1.get(lotto1);
        assertThat(lottoRank1).isEqualTo(LottoRank.FIRST);

        LottoRank lottoRank2 = lottoLottoRankResult1.get(lotto2);
        assertThat(lottoRank2).isEqualTo(LottoRank.SECOND);

        LottoRank lottoRank3 = lottoLottoRankResult1.get(lotto3);
        assertThat(lottoRank3).isEqualTo(LottoRank.THIRD);

        LottoRank lottoRank4 = lottoLottoRankResult1.get(lotto4);
        assertThat(lottoRank4).isEqualTo(LottoRank.FOURTH);

        LottoRank lottoRank5 = lottoLottoRankResult1.get(lotto5);
        assertThat(lottoRank5).isEqualTo(LottoRank.FIFTH);
    }
}
