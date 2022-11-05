package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class AmountTest {
    @Test
    void 생성() {
        assertThat(new Amount(10000)).isEqualTo(new Amount(10000));
    }

    @Test
    void 구매_가능_수량인지_아닌지() {
        assertThat(new Amount(10000).isPurchase(10)).isTrue();
        assertThat(new Amount(10000).isPurchase(11)).isFalse();
    }

    @Test
    void 구매하면_잔고_차감() {
        Amount amount = new Amount(10000);
        amount.purchase(new PurchaseQuantity(1));
        assertThat(amount.getBalance()).isEqualTo(9000);
    }

    @Test
    void 구매_가능_수량() {
        assertThat(new Amount(10000).getPurchase()).isEqualTo(10);
    }
}
