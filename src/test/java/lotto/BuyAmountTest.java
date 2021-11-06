package lotto;

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
        assertThat(buyAmount.getAmount()).isEqualTo(30);
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
}
