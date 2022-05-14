package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PurchasedLottosTest {

    @Test
    public void 구매한_로또_개수_확인() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 3, 5, 7, 9, 11),
                new Lotto(2, 4, 6, 8, 10, 12));
        PurchasedLottos lottos = new PurchasedLottos(lottoList);
        assertThat(lottos.getLottoList()).hasSize(lottoList.size());
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:SECOND", "1,2,3,4,7,8:THIRD", "1,2,3,7,8,9:FOURTH"}, delimiter = ':')
    void 맞춘_개수에_따른_등수_확인(String lottoNumbers, Ranking expected) {
        PurchasedLottos purchasedLottos = new PurchasedLottos(Arrays.asList(new Lotto(lottoNumbers)));
        String lastWinningLotto = "1,2,3,4,5,6";
        List<Ranking> rankings = purchasedLottos.compareLottos(new Lotto(lastWinningLotto));
        assertThat(rankings.get(0)).isEqualTo(expected);
    }
}
