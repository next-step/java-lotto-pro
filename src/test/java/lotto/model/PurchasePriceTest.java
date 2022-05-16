package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class PurchasePriceTest {
    @Test
    void createPurchasePrice() {
        assertThat(new PurchasePrice(15000))
                .usingRecursiveComparison()
                .isEqualTo(new PurchasePrice(15000));
    }

    @Test
    void createPurchasePrice_예외처리() {
        assertAll(
                () -> assertThatThrownBy(() -> new PurchasePrice(999)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new PurchasePrice(1010)).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void purchaseLottoCount() {
        assertThat(new PurchasePrice(5000).purchaseLottoCount()).isEqualTo(5);
    }

    @Test
    void averageRate() {
        assertThat(new PurchasePrice(14000).averageRate(5000)).isEqualTo(0.35);
    }
}