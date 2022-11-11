package lotto.domain;

import lotto.common.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoPurchaseAmountTest {
    @Test
    @DisplayName("구입_금액_양수_채크")
    void 구입_금액_양수_채크() {
        assertThatThrownBy(() -> new LottoPurchaseAmount(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_PURCHASE_AMOUNT_RANGE);
    }

    @Test
    @DisplayName("최대_구입_금액_채크")
    void 최대_구입_금액_채크() {
        assertThatThrownBy(() -> new LottoPurchaseAmount(210000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_PURCHASE_AMOUNT_MAX);
    }

    @Test
    @DisplayName("구입_금액_단위_채크")
    void 구입_금액_단위_채크() {
        assertThat(new LottoPurchaseAmount(5102).getQuantity()).isEqualTo(5);
    }

    @Test
    @DisplayName("구입_금액_로또_갯수_채크")
    void 구입_금액_로또_갯수_채크() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(15000);
        assertThat(lottoPurchaseAmount.getQuantity()).isEqualTo(15);
    }

    @Test
    @DisplayName("구입후_남은티겟_개수_채크")
    void 구입후_남은티겟_개수_채크() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(15000);
        assertThat(lottoPurchaseAmount.pay(3).getQuantity()).isEqualTo(12);
    }
}
