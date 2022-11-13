package lotto.domain;

import lotto.common.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoPurchaseAmountTest {
    @Test
    @DisplayName("구입_금액_양수_채크")
    void 구입_금액_양수_채크() {
        assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_PURCHASE_AMOUNT_RANGE);
    }

    @Test
    @DisplayName("최대_구입_금액_채크")
    void 최대_구입_금액_채크() {
        assertThatThrownBy(() -> new Money(210000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_PURCHASE_AMOUNT_MAX);
    }

    @ParameterizedTest
    @DisplayName("구매가능_여부_채크")
    @CsvSource(value = {"900:false", "1000:true", "1100:true"}, delimiter = ':')
    void 구매가능_여부_채크(int money, boolean expectedResult) {
        Money paidByUser = new Money(money);
        assertThat(paidByUser.canBuy()).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("구입후_남은티겟_금액_채크")
    void 구입후_남은티겟_금액_채크() {
        Money lottoPurchaseAmount = new Money(15000);
        assertThat(lottoPurchaseAmount.pay(new Money(3000)).getValues()).isEqualTo(12000);
    }

    @Test
    @DisplayName("구입후_남은금액_양수_채크")
    void 구입후_남은금액_양수_채크() {
        Money lottoPurchaseAmount = new Money(1000);
        assertThatThrownBy(() -> lottoPurchaseAmount.pay(new Money(2000)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_PURCHASE_AMOUNT_RANGE);
    }
}
