package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoStoreTest {

    private static Money lottoTicketFee;
    private static LottoNumbersSupplier lottoNumbersSupplier;
    private static LottoStore store;

    @BeforeEach
    void setUp() {
        lottoTicketFee = Money.wons(100);
        lottoNumbersSupplier = new UniqueLottoNumbersSupplier();
        store = new LottoStore(lottoTicketFee, lottoNumbersSupplier);
    }

    @DisplayName("고객의 가진 금액이 부족해, 로또를 팔 수 없다")
    @ParameterizedTest
    @ValueSource(ints = {0, 10, 50, 99})
    void canNotSellAll(final int amount) {
        final LottoCustomer customer = new LottoCustomer(Money.wons(amount));

        assertThat(customer.getPurchasedCount()).isEqualTo(0);

        store.sellAllTo(customer);

        assertThat(customer.getPurchasedCount()).isEqualTo(0);
    }

    @DisplayName("고객의 가진 금액이 딱 로또 한 장을 살수 있는 금액이므로, 로또 한 장만 팔 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {100, 150, 199})
    void canSellOnlyOne(final int amount) {
        final LottoCustomer customer = new LottoCustomer(Money.wons(amount));

        assertThat(customer.getPurchasedCount()).isEqualTo(0);

        store.sellAllTo(customer);

        assertThat(customer.getPurchasedCount()).isEqualTo(1);
    }

    @DisplayName("고객의 가진 금액이 로또 여러 장을 살수 있는 금액이므로, 로또 여러 장을 팔 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 100})
    void canSellAll(final int purchaseCount) {
        final LottoCustomer customer = new LottoCustomer(
            lottoTicketFee.multiply(Money.wons(purchaseCount)));

        assertThat(customer.getPurchasedCount()).isEqualTo(0);

        store.sellAllTo(customer);

        assertThat(customer.getPurchasedCount()).isEqualTo(purchaseCount);
    }

}