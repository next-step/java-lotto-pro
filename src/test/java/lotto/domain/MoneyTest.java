package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.LottoConstant.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @ParameterizedTest
    @ValueSource(longs = { LOTTO_PRICE, 2 * LOTTO_PRICE, 100 * LOTTO_PRICE })
    void 구매_가능한_로또_개수(long price) {
        Money money = new Money(price);
        assertThat(money.getAvailableLottosForPurchase()).isEqualTo(price / LOTTO_PRICE);
    }

    @ParameterizedTest
    @ValueSource(longs = { -1 * LOTTO_PRICE, LOTTO_PRICE / 2, LOTTO_PRICE - 1 })
    void 로또_구매_불가한_가격(long price) {
        assertThatThrownBy(() -> {
            new Money(price);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또_총수익_테스트1() {
        PurchasedLotto purchasedLotto = createSamplePurchasedLotto();
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        LottoNo bonusNumber = new LottoNo(7);

        LottoResult result = new LottoResult(purchasedLotto.compareLottos(winningLotto, bonusNumber));
        BigDecimal actual = Money.calculateWinningMoney(result);

        List<Ranking> rankings = Arrays.asList(Ranking.FIRST, Ranking.SECOND, Ranking.THIRD, Ranking.FOURTH);
        BigDecimal expected = rankings.stream()
                .mapToInt(Ranking::getReward)
                .mapToObj(BigDecimal::new)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 로또_수익률_테스트() {
        List<Ranking> rankings = Arrays.asList(Ranking.FIRST, Ranking.SECOND, Ranking.THIRD, Ranking.FOURTH);
        LottoResult result = new LottoResult(rankings);
        Money money = new Money(5000);

        BigDecimal expectedWinningMoney = money.calculateWinningMoney(result);
        BigDecimal divisor = new BigDecimal(money.getMoney());
        BigDecimal expectedProfit = expectedWinningMoney.divide(divisor).setScale(2, RoundingMode.HALF_UP);
        BigDecimal actualProfit = money.calculateWinningProfit(result);

        assertThat(actualProfit).isEqualTo(expectedProfit);
    }

    private PurchasedLotto createSamplePurchasedLotto() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 2, 3, 4, 5, 7),
                new Lotto(1, 2, 3, 4, 5, 8),
                new Lotto(1, 2, 3, 4, 7, 8));
        return new PurchasedLotto(lottoList);
    }
}
