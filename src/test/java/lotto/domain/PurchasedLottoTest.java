package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIRST:45", "1,2,3,4,5,45:SECOND:6", "1,2,3,4,5,45:THIRD:40", "1,2,3,4,7,8:FOURTH:45", "1,2,3,7,8,9:FIFTH:45"}, delimiter = ':')
    void 맞춘_개수에_따른_등수_확인_보너스_여부_포함(String lottoNumbers, Ranking expected, int bonusNumber) {
        PurchasedLotto purchasedLotto = new PurchasedLotto(Arrays.asList(new Lotto(lottoNumbers)));
        String lastWinningLotto = "1,2,3,4,5,6";
        List<Ranking> rankings = purchasedLotto.compareLottos(new Lotto(lastWinningLotto), new LottoNo(bonusNumber));
        assertThat(rankings).containsExactly(expected);
    }
}
