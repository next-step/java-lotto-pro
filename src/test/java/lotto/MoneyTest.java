package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {
    @Test
     void Money_생성() {
        Money money = Money.of(6000, 1);
        assertThat(money.getAllCount()).isEqualTo(6);
        assertThat(money.getAutoCount()).isEqualTo(5);
        assertThat(money.getManualCount()).isEqualTo(1);
    }

    @Test
     void amount_negative() {
        assertThatThrownBy(() -> Money.of(-2000, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 잔액_존재() {
        assertThatThrownBy(() -> Money.of(2500, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수동_입력_개수_초과() {
        assertThatThrownBy(() -> Money.of(2500, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
