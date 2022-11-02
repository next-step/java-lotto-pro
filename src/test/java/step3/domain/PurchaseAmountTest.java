package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class PurchaseAmountTest {

    @DisplayName("구입 금액 생성 테스트")
    @Test
    void 구입금액_생성() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(14000);

        assertThat(purchaseAmount).isInstanceOf(PurchaseAmount.class);
    }

    @DisplayName("구매가능 개수 반환 테스트")
    @ParameterizedTest
    @ValueSource(ints = {14000, 9000, 8000, 8500, 2000, 1000})
    void 구입가능개수(int amount) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        assertThat(purchaseAmount.getLottoTicketCount()).isEqualTo(amount / 1000);
    }

    @DisplayName("구입금액으로 1000원 이하의 값을 입력한 경우 IllegalArgumentException 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, -1000, 999})
    void 구입금액_예외(int purchaseAmount) {
        assertThatThrownBy(() -> new PurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PurchaseAmount.EXCEPTION_MESSAGE_FOR_MINIMUM_PURCHASE_AMOUNT);
    }
}
