package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PurchasedLottoTest {

    @Test
    public void 구매한_로또_개수_확인() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 3, 5, 7, 9, 11),
                new Lotto(2, 4, 6, 8, 10, 12));
        PurchasedLotto lottos = new PurchasedLotto(lottoList);
        assertThat(lottos.getLottoList()).hasSize(lottoList.size());
    }

    @Test
    void 맞춘_개수에_따른_등수_확인_보너스_여부_포함() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto("1, 2, 3, 4, 5, 6"),
                new Lotto("1, 2, 3, 4, 5, 45"),
                new Lotto("1, 2, 3, 4, 5, 40"));
        PurchasedLotto myLotto = new PurchasedLotto(lottos);
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        LottoNo bonusNumber = new LottoNo(45);

        List<Ranking> rankings = myLotto.compareLottos(winningLotto, bonusNumber);
        assertThat(rankings)
                .contains(Ranking.FIRST)
                .contains(Ranking.SECOND)
                .contains(Ranking.THIRD);
    }
}
