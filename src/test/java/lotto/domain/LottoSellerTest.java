package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoSellerTest {

    @DisplayName("구입금액만큼 로또를 발급하여 반환해주는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {14000, 9000, 3500, 4000, 1000})
    void 로또판매(int purchaseAmount) {
        PurchaseAmount amount = new PurchaseAmount(purchaseAmount);
        List<Lotto> lottos = LottoSeller.sellLottos(amount);

        assertThat(lottos).hasSize(amount.getLottoTicketCount());
    }

    @DisplayName("구입금액만큼 로또를 발급하여 반환해주는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1000, 900, 800, 500})
    void 로또판매_금액부족예외(int purchaseAmount) {
        assertThatThrownBy(() -> LottoSeller.sellLottos(new PurchaseAmount(purchaseAmount)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PurchaseAmount.EXCEPTION_MESSAGE_FOR_MINIMUM_PURCHASE_AMOUNT);
    }

    @DisplayName("로또 발급 테스트")
    @Test
    void 로또발급테스트() {
        LottoCreateStrategy strategy = new AutoLottoCreateStrategy();
        assertThat(strategy.createLotto()).isInstanceOf(Lotto.class);
    }
}
