package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
    public void 로또_총수익_테스트1() {
        PurchasedLotto purchasedLotto = createSamplePurchasedLotto();
        LottoResult result = new LottoResult(purchasedLotto.compareLottos(new Lotto(1, 2, 3, 4, 5, 6)));
        BigDecimal actualWinningMoney = result.calculateWinningMoney();

        BigDecimal expectedWinningMoney = new BigDecimal(0);
        for (int matchingCount = LOTTO_MINIMUM_MATCHING_COUNT; matchingCount <= LOTTO_SIZE; matchingCount++) {
            List<Ranking> list = result.findRankings(matchingCount);
            Ranking ranking = Ranking.findRank(matchingCount, false);
            expectedWinningMoney = expectedWinningMoney.add(new BigDecimal(ranking.getReward() * list.size()));
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

    @Test
    public void 로또_총수익_테스트2() {
        List<Ranking> rankings = Arrays.asList(Ranking.FIRST, Ranking.SECOND, Ranking.THIRD, Ranking.FOURTH);
        BigDecimal expectedWinningMoney = rankings.stream()
                .mapToInt(Ranking::getReward)
                .mapToObj(BigDecimal::new)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        LottoResult result = new LottoResult(rankings);
        BigDecimal actualWinningMoney = result.calculateWinningMoney();
        assertThat(actualWinningMoney).isEqualTo(expectedWinningMoney);
    }

    @Test
    public void 로또_수익률_테스트() {
        List<Ranking> rankings = Arrays.asList(Ranking.FIRST, Ranking.SECOND, Ranking.THIRD, Ranking.FOURTH);
        LottoResult result = new LottoResult(rankings);
        Money money = new Money(5000);

        BigDecimal expectedWinningMoney = result.calculateWinningMoney();
        BigDecimal divisor = new BigDecimal(money.getMoney());
        BigDecimal expectedProfit = expectedWinningMoney.divide(divisor).setScale(2, RoundingMode.HALF_UP);

        BigDecimal actualProfit = result.calculateWinningProfit(money);
        assertThat(actualProfit).isEqualTo(expectedProfit);
    }
}
