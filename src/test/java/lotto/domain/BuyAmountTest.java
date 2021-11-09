package lotto.domain;

import lotto.exception.MinimumTicketPriceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("구매 개수 관련 테스트")
public class BuyAmountTest {
    @DisplayName("구매 개수 테스트")
    @Test
    void getBuyAmountTest() {
        int buyPrice = 30000;
        // when
        BuyAmount buyAmount = new BuyAmount(buyPrice);
        assertThat(buyAmount.getTotalAmount()).isEqualTo(30);
    }

    @DisplayName("구매 오류 테스트")
    @Test
    void getBuyAmountExceptionTest() {
        int buyPrice = 100;
        // when
        assertThatThrownBy(() -> {
            BuyAmount buyAmount = new BuyAmount(buyPrice);
        }).isInstanceOf(MinimumTicketPriceException.class)
        .hasMessageContaining("구입 금액을 확인해 주세요.");
    }

    @DisplayName("수동 구매 크기 초과 테스트")
    @Test
    void getManualBuyAmountSizeExceptionTest() {
        int buyPrice = 3000;
        // when
        assertThatThrownBy(() -> {
            BuyAmount buyAmount = new BuyAmount(buyPrice, 5);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("수동 로또 구매 수를 확인해 주세요.");
    }
}
