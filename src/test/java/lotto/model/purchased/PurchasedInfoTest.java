package lotto.model.purchased;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasedInfoTest {

    @Test
    @DisplayName("가능한 로또 개수만큼 자동 생성되는지 확인한다.")
    void 자동로또가_생성되는지_확인() {
        PurchasedInfo purchasedInfo = new PurchasedInfo(new Money("14000"));
        assertThat(purchasedInfo.getPurchasedLottos()).hasSize(14);
    }

}
