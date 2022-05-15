package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static lotto.domain.LottoConstant.LOTTO_MINIMUM_MATCHING_COUNT;
import static lotto.domain.LottoConstant.LOTTO_SIZE;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @ParameterizedTest
    @CsvSource(value = {"6|1", "5|0", "4|0", "3|2"}, delimiter = '|')
    public void 로또_결과_조회_테스트(int matchingCount, int listSize) {
        PurchasedLotto purchasedLotto = createSamplePurchasedLotto();
        LottoResult result = new LottoResult(purchasedLotto.compareLottos(new Lotto(1, 2, 3, 4, 5, 6)));
        List<Ranking> firstRankings = result.findRankings(matchingCount);
        assertThat(firstRankings).hasSize(listSize);
    }

    @Test
    public void 총_당첨_금액_계산() {
        PurchasedLotto purchasedLotto = createSamplePurchasedLotto();
        LottoResult result = new LottoResult(purchasedLotto.compareLottos(new Lotto(1, 2, 3, 4, 5, 6)));
        int actualWinningMoney = result.calculateWinningMoney();

        int expectedWinningMoney = 0;
        for (int matchingCount = LOTTO_MINIMUM_MATCHING_COUNT; matchingCount <= LOTTO_SIZE; matchingCount++) {
            List<Ranking> list = result.findRankings(matchingCount);
            Ranking ranking = Ranking.findRank(matchingCount);
            expectedWinningMoney += ranking.getReward() * list.size();
        }
        assertThat(actualWinningMoney).isEqualTo(expectedWinningMoney);
    }

    private PurchasedLotto createSamplePurchasedLotto() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 3, 5, 7, 9, 11),
                new Lotto(2, 4, 6, 8, 10, 12));
        return new PurchasedLotto(lottoList);
    }
}
