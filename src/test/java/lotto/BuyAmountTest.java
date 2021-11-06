package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyAmountTest {
    @DisplayName("구매 개수 테스트")
    @Test
    void getBuyAmountTest() {
        int buyPrice = 30000;
        // when
        BuyAmount buyAmount = new BuyAmount(buyPrice);
        assertThat(buyAmount.getAmount()).isEqualTo(30);
    }
}
