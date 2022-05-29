package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class MoneyTest {
    @Test
    @DisplayName("1000원보다 작을 경우 오류가 발생한다.")
    void checkException() {
        assertAll(
            () -> assertThatThrownBy(() -> new Money(-1)).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new Money(0)).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new Money(999)).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("1000원 이상일 경우 객체가 생성된다.")
    void checkValidMoney() {
        assertAll(
            () -> assertThat(new Money(1000).getMoney()).isEqualTo(1000),
            () -> assertThat(new Money(2000).getMoney()).isEqualTo(2000),
            () -> assertThat(new Money(3000).getMoney()).isEqualTo(3000)
        );
    }

    @Test
    @DisplayName("돈과 수동 구매개수가 주어졌을 때 자동구매개수를 구한다.")
    void checkMoney() {
        Money money = new Money(3000);

        assertAll(
            () -> assertThat(money.autoCount(new ManualLottoTicketCount(0))).isEqualTo(3),
            () -> assertThat(money.autoCount(new ManualLottoTicketCount(1))).isEqualTo(2),
            () -> assertThat(money.autoCount(new ManualLottoTicketCount(3))).isEqualTo(0)
        );
    }
}
