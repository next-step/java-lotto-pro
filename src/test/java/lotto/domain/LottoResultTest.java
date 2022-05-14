package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    private PurchasedLottos purchasedLottos;

    @BeforeEach
    public void beforeEach() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 3, 5, 7, 9, 11),
                new Lotto(2, 4, 6, 8, 10, 12));
        purchasedLottos = new PurchasedLottos(lottoList);
    }

    @Test
    public void 로또_결과_조회_테스트() {
        LottoResult result = new LottoResult(purchasedLottos.compareLottos(new Lotto(1, 2, 3, 4, 5, 6)));
        List<Ranking> firstRankings = result.findRankings(6);
        assertThat(firstRankings).hasSize(1);

        List<Ranking> fourthRankings = result.findRankings(3);
        assertThat(fourthRankings).hasSize(2);
    }

    @Test
    public void 총_당첨_금액_계산() {
        LottoResult result = new LottoResult(purchasedLottos.compareLottos(new Lotto(1, 2, 3, 4, 5, 6)));
        int winningMoney = result.calculateWinningMoney();
        assertThat(winningMoney).isEqualTo(2000010000);
    }
}
