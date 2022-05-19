package lotto.domain;

import lotto.type.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @Test
    @DisplayName("로또등수를 확인한다.")
    void 로또_등수_확인() {
        Lotto lotto = new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto answerLotto = new Lotto(new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9)));

        Lottos lottos = new Lottos(Collections.singletonList(lotto));
        Map<Lotto, LottoRank> lottoLottoRankResult = lottos.lottoWinningResult(answerLotto);

        LottoRank lottoRank = lottoLottoRankResult.get(lotto);
        assertThat(lottoRank).isEqualTo(LottoRank.FOURTH);
    }
}
