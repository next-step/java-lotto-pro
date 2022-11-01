package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoCustomerTest {

    private static LottoTicket lottoTicket;

    @BeforeEach
    void setup() {
        lottoTicket = LottoTicket.of(Money.wons(100), 1, 2, 3, 4, 5, 6);
    }

    @DisplayName("가진 금액이 부족해, 로또를 구입 할 수 없다")
    @ParameterizedTest
    @ValueSource(ints = {0, 50, 99})
    void purchase_ng(final int amount) {
        final Money initialAmount = Money.wons(amount);
        final LottoCustomer customer = new LottoCustomer(initialAmount);

        assertThat(customer.getRemainingAmount().isLessThan(lottoTicket.getFee())).isTrue();
        assertThat(customer.canPurchase(lottoTicket)).isFalse();
        assertThat(customer.getPurchasedCount()).isEqualTo(0);
        assertThat(customer.getRemainingAmount()).isEqualTo(initialAmount);
    }

    @DisplayName("가진 금액으로, 딱 한번 로또를 구입 할 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {100, 101, 150, 199})
    void purchase_ok(final int amount) {
        final Money initialAmount = Money.wons(amount);
        final LottoCustomer customer = new LottoCustomer(initialAmount);

        assertThat(customer.canPurchase(lottoTicket)).isTrue();
        assertThat(customer.getPurchasedCount()).isEqualTo(0);
        assertThat(customer.getRemainingAmount().isLessThan(initialAmount)).isFalse();
        assertThat(customer.getRemainingAmount().isLessThan(lottoTicket.getFee())).isFalse();

        customer.purchase(lottoTicket);

        assertThat(customer.canPurchase(lottoTicket)).isFalse();
        assertThat(customer.getPurchasedCount()).isEqualTo(1);
        assertThat(customer.getRemainingAmount().isLessThan(initialAmount)).isTrue();
        assertThat(customer.getRemainingAmount().isLessThan(lottoTicket.getFee())).isTrue();
    }

    @DisplayName("가진 금액으로, 구입 가능한 만큼, 로또를  구입 할 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 100})
    void purchase_multipleTimes(final int purchaseCount) {
        final Money initialAmount = lottoTicket.getFee().multiply(Money.wons(purchaseCount));
        final LottoCustomer customer = new LottoCustomer(initialAmount);

        assertThat(customer.canPurchase(lottoTicket)).isTrue();
        assertThat(customer.getPurchasedCount()).isEqualTo(0);
        assertThat(customer.getRemainingAmount().isLessThan(initialAmount)).isFalse();
        assertThat(customer.getRemainingAmount().isLessThan(lottoTicket.getFee())).isFalse();

        while (customer.canPurchase(lottoTicket)) {
            customer.purchase(lottoTicket);
        }

        assertThat(customer.canPurchase(lottoTicket)).isFalse();
        assertThat(customer.getPurchasedCount()).isEqualTo(purchaseCount);
        assertThat(customer.getRemainingAmount().isLessThan(initialAmount)).isTrue();
        assertThat(customer.getRemainingAmount().isLessThan(lottoTicket.getFee())).isTrue();
    }
}