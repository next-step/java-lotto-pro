package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CashierTest {

    @Test
    @DisplayName("금액이 1000원 이상인지 검증")
    public void minimumAmount() {
        assertThatThrownBy(() -> new Cashier(900).receiveAmount()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액이 1000원 단위인지 검증")
    public void validAmount() {
        assertThatThrownBy(() -> new Cashier(1500).receiveAmount()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액이 입력한 대로 저장되는지 확인")
    public void receiveAmount() {
        assertThat(new Cashier(15000).receiveAmount()).isEqualTo(15000);
    }
}
