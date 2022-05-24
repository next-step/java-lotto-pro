package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseMoneyTest {

    @DisplayName("PurchaseMoney 생성시 입력한 금액을 포함하고 있는지 확인")
    @Test
    void getMoney() {
        PurchaseMoney result = new PurchaseMoney(7600);
        assertThat(result.getMoney()).isEqualTo(7600);
    }

    @DisplayName("PurchaseMoney 생성시 입력한 금액의 구매가능한 만큼의 로또 수량인지 확인")
    @Test
    void getAmountOfLotto() {
        PurchaseMoney result = new PurchaseMoney(7600);
        assertThat(result.getPurchasableQuantity()).isEqualTo(7);
    }

    @DisplayName("수익률 계산이 정상적으로 동작하는지 확인")
    @Test
    void calculateEarningsRate() {
        PurchaseMoney money = new PurchaseMoney(2000);
        assertThat(money.calculateEarningsRate(1000)).isEqualTo(0.5);
    }

    @DisplayName("음수 금액으로 PurchaseMoney 생성시 Exception 발생 확인")
    @Test
    void purchaseMoneyWithNegative() {
        assertThatThrownBy(() -> new PurchaseMoney(-100)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 가격 미만 금액 입력시 Exception 발생 확인")
    @Test
    void purchaseMoneyWithLowerThanPrice() {
        assertThatThrownBy(() -> new PurchaseMoney(400)).isInstanceOf(IllegalArgumentException.class);
    }

}
