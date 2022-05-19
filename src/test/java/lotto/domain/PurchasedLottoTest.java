package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PurchasedLottoTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:THIRD", "1,2,3,4,7,8:FOURTH", "1,2,3,7,8,9:FIFTH"}, delimiter = ':')
    public void 번호_맞춘_개수에_대한_등수_확인(String lottoNumbers, Ranking expected) {
        Lotto lastWinningLotto = new Lotto("1,2,3,4,5,6");
        PurchasedLotto purchasedLotto = new PurchasedLotto(Arrays.asList(new Lotto(lottoNumbers)));
        LottoResult lottoResult = purchasedLotto.matchLottoNumbers(lastWinningLotto, new LottoNo(45));

        assertThat(lottoResult.getRankingList()).containsExactly(expected);
    }

    @Test
    public void 맞춘_번호_개수에_대한_등수_확인_보너스_포함() {
        List<Lotto> lottos = createSampleLottos();
        PurchasedLotto myLotto = new PurchasedLotto(lottos);
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        LottoNo bonusNumber = new LottoNo(45);

        LottoResult lottoResult = myLotto.matchLottoNumbers(winningLotto, bonusNumber);

        assertThat(lottoResult.getRankingList())
                .contains(Ranking.FIRST)
                .contains(Ranking.SECOND)
                .contains(Ranking.THIRD);
    }

    @Test
    public void 구매한_로또_개수_확인() {
        List<Lotto> lottoList = createSampleLottos();
        PurchasedLotto lottos = new PurchasedLotto(lottoList);
        assertThat(lottos.getLottoList()).hasSize(lottoList.size());
    }

    @Test
    void 맞춘_개수에_따른_등수_확인_보너스_여부_포함() {
        List<Lotto> lottos = createSampleLottos();
        PurchasedLotto myLotto = new PurchasedLotto(lottos);
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        LottoNo bonusNumber = new LottoNo(45);

        List<Ranking> rankings = myLotto.compareLottos(winningLotto, bonusNumber);
        assertThat(rankings)
                .contains(Ranking.FIRST)
                .contains(Ranking.SECOND)
                .contains(Ranking.THIRD);
    }

    @Test
    void 구매_로또_일괄_추가_테스트() {
        PurchasedLotto lottos01 = new PurchasedLotto(createSampleLottos());
        PurchasedLotto lottos02 = new PurchasedLotto(createSampleLottos());
        lottos01.append(lottos02);
        assertThat(lottos01.getLottoList()).hasSize(6);
    }

    private static List<Lotto> createSampleLottos() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto("1, 2, 3, 4, 5, 6"));
        lottos.add(new Lotto("1, 2, 3, 4, 5, 45"));
        lottos.add(new Lotto("1, 2, 3, 4, 5, 40"));
        return lottos;
    }
}
