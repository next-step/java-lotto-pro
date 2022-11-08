package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoSellerTest {

    private List<Lotto> manualLottos;

    @BeforeEach
    void setUp() {
        manualLottos = new ArrayList<>();
        manualLottos.add(new Lotto(Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        )));
    }

    @DisplayName("구입금액만큼 로또를 발급하여 반환해주는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1000, 900, 800, 500})
    void 로또판매_금액부족예외(int purchaseAmount) {
        assertThatThrownBy(() -> LottoSeller.sellAutoLottos(new PurchaseAmount(purchaseAmount).getLottoTicketCount()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PurchaseAmount.EXCEPTION_MESSAGE_FOR_MINIMUM_PURCHASE_AMOUNT);
    }

    @DisplayName("구입금액만큼 로또를 발급하여 반환해주는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {14000, 9000, 3500, 4000, 1000})
    void 로또_자동발급테스트(int purchaseAmount) {
        Lottos lottos = LottoSeller.sellAutoLottos(new PurchaseAmount(purchaseAmount).getLottoTicketCount());
        assertThat(lottos.lottos()).hasSize(purchaseAmount / PurchaseAmount.LOTTO_TICKET_PRICE);
    }

    @DisplayName("로또 수동발급 테스트")
    @Test
    void 로또_수동발급테스트() {
        Lottos lottos = LottoSeller.sellManualLottos(manualLottos);
        assertThat(lottos).isInstanceOf(Lottos.class);
    }

    @DisplayName("발급한 로또들 2개를 통합 테스트")
    @Test
    void 로또_통합() {
        // given
        Lottos autoLottos = LottoSeller.sellAutoLottos(new PurchaseAmount(10000).getLottoTicketCount());
        Lottos manualLoottos = LottoSeller.sellManualLottos(manualLottos);

        // when
        Lottos integrationLottos = LottoSeller.integrationLottos(manualLoottos, autoLottos);

        // then
        assertThat(integrationLottos.lottos()).hasSize(11);
    }
}
