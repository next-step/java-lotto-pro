package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoCustomer;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResultStatistics;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoCustomerTest {

    private static LottoTicket lottoTicket1;
    private static LottoTicket lottoTicket2;
    private static LottoCustomer customer;

    @BeforeEach
    void setup() {
        lottoTicket1 = new LottoTicket(Money.wons(100), LottoNumbers.of(1, 2, 3, 4, 5, 6));
        lottoTicket2 = new LottoTicket(Money.wons(200), LottoNumbers.of(45, 44, 43, 42, 41, 40));
        customer = new LottoCustomer(Money.wons(1_000));
    }

    @DisplayName("가진 금액이, 로또 구매 가격보다 적다면, 로또를 구입 할 수 없다")
    @ParameterizedTest
    @ValueSource(ints = {0, 50, 99})
    void purchase_nothing(final int amount) {
        final Money initialAmount = Money.wons(amount);
        final LottoCustomer customer = new LottoCustomer(initialAmount);

        // Validate PreCondition
        assertThat(customer.getRemainingAmount().isLessThan(lottoTicket1.getFee())).isTrue();
        assertThat(customer.canPurchase(lottoTicket1)).isFalse();

        assertThat(customer.purchase(lottoTicket1)).isEqualTo(Money.ZERO);

        // Validate PostCondition
        assertThat(customer.getPurchasedCount()).isZero();
        assertThat(customer.getRemainingAmount()).isEqualTo(initialAmount);
    }

    @DisplayName("가진 금액이, 로또를 딱 한 번 구매 가능한 금액이라면, 로또를 한 번 구입할 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {100, 101, 150, 199})
    void purchase_onlyOne(final int amount) {
        final Money initialAmount = Money.wons(amount);
        final LottoCustomer customer = new LottoCustomer(initialAmount);

        // Validate PreCondition
        assertThat(customer.getRemainingAmount().isLessThan(lottoTicket1.getFee())).isFalse();
        assertThat(customer.getRemainingAmount()).isEqualTo(initialAmount);
        assertThat(customer.canPurchase(lottoTicket1)).isTrue();
        assertThat(customer.getPurchasedCount()).isEqualTo(0);

        assertThat(customer.purchase(lottoTicket1)).isEqualTo(lottoTicket1.getFee());

        // Validate PostCondition
        assertThat(customer.getRemainingAmount().isLessThan(initialAmount)).isTrue();
        assertThat(customer.getRemainingAmount().isLessThan(lottoTicket1.getFee())).isTrue();
        assertThat(customer.canPurchase(lottoTicket1)).isFalse();
        assertThat(customer.getPurchasedCount()).isEqualTo(1);
    }

    @DisplayName("가진 금액으로, 구입 가능한 만큼, 로또를 구입 할 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 100})
    void purchase_multiple(final int purchaseCount) {
        final Money initialAmount = lottoTicket1.getFee().multiply(Money.wons(purchaseCount));
        final LottoCustomer customer = new LottoCustomer(initialAmount);

        while (customer.canPurchase(lottoTicket1)) {
            customer.purchase(lottoTicket1);
        }

        assertThat(customer.getRemainingAmount().isLessThan(initialAmount)).isTrue();
        assertThat(customer.getRemainingAmount().isLessThan(lottoTicket1.getFee())).isTrue();
        assertThat(customer.getPurchasedCount()).isEqualTo(purchaseCount);
    }

    @DisplayName("로또 구매전후로, 구입한 로또 번호 목록을 반환 할 수 있어야 한다")
    @Test
    void getPurchasedLottoNumbers() {
        assertThat(customer.getPurchasedCount()).isZero();
        assertThat(customer.getPurchasedLottoNumbers()).isEmpty();

        customer.purchase(lottoTicket1);

        assertThat(customer.getPurchasedCount()).isEqualTo(1);
        assertThat(customer.getPurchasedLottoNumbers())
            .containsExactly(LottoNumbers.of(1, 2, 3, 4, 5, 6));

        customer.purchase(lottoTicket2);

        assertThat(customer.getPurchasedCount()).isEqualTo(2);
        assertThat(customer.getPurchasedLottoNumbers())
            .containsExactly(
                LottoNumbers.of(1, 2, 3, 4, 5, 6),
                LottoNumbers.of(45, 44, 43, 42, 41, 40));
    }

    @DisplayName("당첨 로또를 모르는 상태에선, 모든 당첨 횟수는 ZERO여야 한다")
    @Test
    void getResultStats_beforeSettingWiningLottoNumbers() {
        customer.purchase(lottoTicket1);

        final LottoResultStatistics resultStats = customer.getResultStats();

        assertThat(resultStats.getFirstRankCount()).isZero();
        assertThat(resultStats.getSecondRankCount()).isZero();
        assertThat(resultStats.getThirdRankCount()).isZero();
        assertThat(resultStats.getFourthRankCount()).isZero();
    }

    @DisplayName("아무것도 당첨되지 않았을 경우, 모든 당첨 횟수는 ZERO여야 한다")
    @Test
    void getResultStats_winingNothing() {
        customer.purchase(lottoTicket1);
        customer.setWiningLottoNumbers(LottoNumbers.of(7, 8, 9, 10, 11, 12));

        final LottoResultStatistics resultStats = customer.getResultStats();

        assertThat(resultStats.getFirstRankCount()).isZero();
        assertThat(resultStats.getSecondRankCount()).isZero();
        assertThat(resultStats.getThirdRankCount()).isZero();
        assertThat(resultStats.getFourthRankCount()).isZero();
    }

    @DisplayName("1등이 당첨되었을 경우, 1등을 제외한 당첨 횟수는 ZERO여야 한다")
    @Test
    void getResultStats_winingFirst() {
        customer.purchase(lottoTicket1);
        customer.setWiningLottoNumbers(LottoNumbers.of(1, 2, 3, 4, 5, 6));

        final LottoResultStatistics resultStats = customer.getResultStats();

        assertThat(resultStats.getFirstRankCount()).isEqualTo(1);
        assertThat(resultStats.getSecondRankCount()).isZero();
        assertThat(resultStats.getThirdRankCount()).isZero();
        assertThat(resultStats.getFourthRankCount()).isZero();
    }

    @DisplayName("2등이 당첨되었을 경우, 2등을 제외한 당첨 횟수는 ZERO여야 한다")
    @Test
    void getResultStats_winingSecond() {
        customer.purchase(lottoTicket1);
        customer.setWiningLottoNumbers(LottoNumbers.of(1, 2, 3, 4, 5, 45));

        final LottoResultStatistics resultStats = customer.getResultStats();

        assertThat(resultStats.getFirstRankCount()).isZero();
        assertThat(resultStats.getSecondRankCount()).isEqualTo(1);
        assertThat(resultStats.getThirdRankCount()).isZero();
        assertThat(resultStats.getFourthRankCount()).isZero();
    }

    @DisplayName("3등이 당첨되었을 경우, 3등을 제외한 당첨 횟수는 ZERO여야 한다")
    @Test
    void getResultStats_winingThird() {
        customer.purchase(lottoTicket1);
        customer.setWiningLottoNumbers(LottoNumbers.of(1, 2, 3, 4, 40, 45));

        final LottoResultStatistics resultStats = customer.getResultStats();

        assertThat(resultStats.getFirstRankCount()).isZero();
        assertThat(resultStats.getSecondRankCount()).isZero();
        assertThat(resultStats.getThirdRankCount()).isEqualTo(1);
        assertThat(resultStats.getFourthRankCount()).isZero();
    }

    @DisplayName("4등이 당첨되었을 경우, 4등을 제외한 당첨 횟수는 ZERO여야 한다")
    @Test
    void getResultStats_winingFourth() {
        customer.purchase(lottoTicket1);
        customer.setWiningLottoNumbers(LottoNumbers.of(1, 2, 3, 35, 40, 45));

        final LottoResultStatistics resultStats = customer.getResultStats();

        assertThat(resultStats.getFirstRankCount()).isZero();
        assertThat(resultStats.getSecondRankCount()).isZero();
        assertThat(resultStats.getThirdRankCount()).isZero();
        assertThat(resultStats.getFourthRankCount()).isEqualTo(1);
    }

    @DisplayName("복수의 로또가 당첨되었을 경우, 각 등수의 당첨 횟수를 반환해야 한다")
    @Test
    void getResultStats_winingAll() {
        customer.setWiningLottoNumbers(LottoNumbers.of(1, 2, 3, 4, 5, 6));

        // First
        customer.purchase(new LottoTicket(Money.ONE, LottoNumbers.of(1, 2, 3, 4, 5, 6)));
        // Second
        customer.purchase(new LottoTicket(Money.ONE, LottoNumbers.of(1, 2, 3, 4, 5, 45)));
        customer.purchase(new LottoTicket(Money.ONE, LottoNumbers.of(1, 2, 3, 4, 45, 6)));
        // Third
        customer.purchase(new LottoTicket(Money.ONE, LottoNumbers.of(1, 2, 3, 4, 40, 45)));
        customer.purchase(new LottoTicket(Money.ONE, LottoNumbers.of(1, 2, 30, 40, 5, 6)));
        customer.purchase(new LottoTicket(Money.ONE, LottoNumbers.of(10, 20, 3, 4, 5, 6)));
        // Fourth
        customer.purchase(new LottoTicket(Money.ONE, LottoNumbers.of(1, 2, 3, 35, 40, 45)));
        // Nothing
        customer.purchase(new LottoTicket(Money.ONE, LottoNumbers.of(1, 2, 30, 35, 40, 45)));
        customer.purchase(new LottoTicket(Money.ONE, LottoNumbers.of(1, 20, 30, 35, 40, 45)));
        customer.purchase(new LottoTicket(Money.ONE, LottoNumbers.of(10, 20, 30, 35, 40, 45)));

        final LottoResultStatistics resultStats = customer.getResultStats();

        assertThat(resultStats.getFirstRankCount()).isEqualTo(1);
        assertThat(resultStats.getSecondRankCount()).isEqualTo(2);
        assertThat(resultStats.getThirdRankCount()).isEqualTo(3);
        assertThat(resultStats.getFourthRankCount()).isEqualTo(1);
    }

    @DisplayName("당첨 로또 번호를 모르는 상태에선, 수익률은 ZERO여야 한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10})
    void getProfitRate_beforeSettingWiningLottoNumbers(final int initialAmount) {
        assertThat(new LottoCustomer(Money.wons(initialAmount)).getProfitRate()).isZero();
    }

    @DisplayName("로또를 구매하지 않은 상태에선, 수익률은 ZERO여야 한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10})
    void getProfitRate_beforePurchasing(final int initialAmount) {
        final LottoCustomer customer = new LottoCustomer(Money.wons(initialAmount));

        customer.setWiningLottoNumbers(LottoNumbers.of(1, 2, 3, 4, 5, 6));
        assertThat(customer.getProfitRate()).isZero();
    }

    @DisplayName("당첨 되지 않았을 경우, 수익률은 0이어야 한다")
    @Test
    void getProfitRate_zero() {
        final LottoCustomer customer = new LottoCustomer(Money.wons(8_000));
        customer.purchase(new LottoTicket(Money.wons(1_000), LottoNumbers.of(1, 2, 3, 4, 5, 6)));

        customer.setWiningLottoNumbers(LottoNumbers.of(7, 8, 9, 10, 11, 12));
        assertThat(customer.getProfitRate()).isZero();
    }

    @DisplayName("로또 구입 금액보다, 로또 당첨 상금이 낮을때, 수익률은 1이하여야 한다")
    @Test
    void getProfitRate_lessThanOne() {
        final LottoCustomer customer = new LottoCustomer(Money.wons(8_000));
        customer.purchase(new LottoTicket(Money.wons(1_000), LottoNumbers.of(1, 2, 3, 4, 5, 6)));

        customer.setWiningLottoNumbers(LottoNumbers.of(1, 2, 3, 10, 11, 12));
        assertThat(customer.getProfitRate()).isLessThan(Double.valueOf(1));
    }

    @DisplayName("로또 구입 금액과, 로또 당첨 상금이 같으면, 수익률은 1이여야 한다")
    @Test
    void getProfitRate_one() {
        final LottoCustomer customer = new LottoCustomer(Money.wons(5_000));
        customer.purchase(new LottoTicket(Money.wons(5_000), LottoNumbers.of(1, 2, 3, 4, 5, 6)));

        customer.setWiningLottoNumbers(LottoNumbers.of(1, 2, 3, 10, 15, 20));
        assertThat(customer.getProfitRate()).isEqualTo(Double.valueOf(1));
    }

    @DisplayName("로또 구입 금액보다, 로또 당첨 상금이 높으면, 수익률은 1이상이여야 한다")
    @Test
    void getProfitRate_greaterThanOne() {
        final LottoCustomer customer = new LottoCustomer(Money.wons(1_000));
        customer.purchase(new LottoTicket(Money.wons(1_000), LottoNumbers.of(1, 2, 3, 4, 5, 6)));

        customer.setWiningLottoNumbers(LottoNumbers.of(1, 2, 3, 10, 15, 20));
        assertThat(customer.getProfitRate()).isEqualTo(Double.valueOf(5));
    }


}