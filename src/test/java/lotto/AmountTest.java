package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class AmountTest {
    @Test
    void 생성() {
        assertThat(new Amount(10000)).isEqualTo(new Amount(10000));
    }

    @Test
    void 구매_가능_수량인지_아닌지() {
        assertThatThrownBy(() -> new Amount(10000).isPurchase(Quantity.from(11))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 구매하면_잔고_차감() {
        Amount amount = new Amount(10000);
        amount.purchase(Quantity.from(1));
        assertThat(amount.getBalance()).isEqualTo(9000);
    }

    @Test
    void 구매_가능_수량() {
        assertThat(new Amount(10000).getPurchase()).isEqualTo(10);
    }
}
