package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseQuantityTest {

    @DisplayName("구매금액 20000원일 때 총 구매수량 확인")
    @Test
    void getTotalQuantity() {
        PurchaseQuantity purchaseQuantity = new PurchaseQuantity(new PurchaseMoney(20000), 10);
        assertThat(purchaseQuantity.getTotalQuantity()).isEqualTo(20);
    }

    @DisplayName("구매금액 32100원이고 수동 구매수량이 15일 때 수동 구매수량 확인")
    @Test
    void getManualQuantity() {
        PurchaseQuantity purchaseQuantity = new PurchaseQuantity(new PurchaseMoney(32100), 15);
        assertThat(purchaseQuantity.getManualQuantity()).isEqualTo(15);
    }

    @DisplayName("구매금액 26900원이고 수동 구매수량이 12일 때 자동 구매수량 확인")
    @Test
    void getAutoQuantity() {
        PurchaseQuantity purchaseQuantity = new PurchaseQuantity(new PurchaseMoney(26900), 12);
        assertThat(purchaseQuantity.getAutoQuantity()).isEqualTo(14);
    }

    @DisplayName("구매금액이 null 일 경우 Exception 발생 확인")
    @Test
    void purchaseMoneyNull() {
        assertThatThrownBy(() -> new PurchaseQuantity(null, 12)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동 구매수량이 음수일 경우 Exception 발생 확인")
    @Test
    void manualQuantityNegative() {
        assertThatThrownBy(() -> new PurchaseQuantity(new PurchaseMoney(26900), -5)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("수동 구매수량이 총 구매수량을 넘을 경우 Exception 발생 확인")
    @Test
    void manualQuantityOverTotal() {
        assertThatThrownBy(() -> new PurchaseQuantity(new PurchaseMoney(26900), 27)).isInstanceOf(
                IllegalArgumentException.class);
    }
}
