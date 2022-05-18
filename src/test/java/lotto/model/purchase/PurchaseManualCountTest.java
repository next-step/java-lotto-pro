package lotto.model.purchase;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.model.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseManualCountTest {

    @Test
    @DisplayName("구입 금액을 초과하여 구입한 경우 예외처리")
    void 구입금액_초과_테스트() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new PurchaseManualCount("4", new Money(3000)));
    }

}
