package lotto;

import lotto.domain.BoughtMoney;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoughtMoneyTest {
    @Test
    void 구매금액_0원_미만의금액_입력() {
        Assertions.assertThatThrownBy(() ->
                new BoughtMoney(-1000)).isInstanceOf(IllegalArgumentException.class);
    }
}
