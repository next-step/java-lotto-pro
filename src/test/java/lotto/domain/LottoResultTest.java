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

    @Test
    public void 로또_당첨_결과_조회_테스트() {
        PurchasedLotto purchasedLotto = createSamplePurchasedLotto();
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        LottoNo bonusNumber = new LottoNo(7);

        LottoResult result = new LottoResult(purchasedLotto.compareLottos(winningLotto, bonusNumber));

        assertThat(result.getRankingList())
                .contains(Ranking.FIRST)
                .contains(Ranking.SECOND)
                .contains(Ranking.THIRD)
                .contains(Ranking.FOURTH);
    }

    @Test
    public void 로또_총수익_테스트1() {
        PurchasedLotto purchasedLotto = createSamplePurchasedLotto();
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        LottoNo bonusNumber = new LottoNo(7);

        LottoResult result = new LottoResult(purchasedLotto.compareLottos(winningLotto, bonusNumber));
        BigDecimal actual = result.calculateWinningMoney();

        List<Ranking> rankings = Arrays.asList(Ranking.FIRST, Ranking.SECOND, Ranking.THIRD, Ranking.FOURTH);
        BigDecimal expected = rankings.stream()
                .mapToInt(Ranking::getReward)
                .mapToObj(BigDecimal::new)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        assertThat(actual).isEqualTo(expected);
    }

    private PurchasedLotto createSamplePurchasedLotto() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 2, 3, 4, 5, 7),
                new Lotto(1, 2, 3, 4, 5, 8),
                new Lotto(1, 2, 3, 4, 7, 8));
        return new PurchasedLotto(lottoList);
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
