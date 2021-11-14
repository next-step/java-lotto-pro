package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoManualTest {

    @DisplayName("수동으로 구매하는 로또 수는 로또 구입금액을 초과할 수 없다.")
    @Test
    void lottoManualPurchaseCountExcessMoney() {
        final int lottoManualPurchaseCount = 2;
        final Money money = new Money(1000);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoManual(lottoManualPurchaseCount, money);
        });
    }
}
