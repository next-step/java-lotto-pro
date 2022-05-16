package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoPurchaseTest {
    @Test
    @DisplayName("로또구매가격이 올바르지 않을 때 예외처리한다.")
    void 로또구매가격_오류_예외() {
        assertThatThrownBy(
                () -> {
                    new LottoPurchase("1,000");
                }
        );
    }

    @Test
    @DisplayName("로또구매갯수를 확인한다.")
    void 로또구매갯수_확인() {
        LottoPurchase lottoPurchase = new LottoPurchase("500000");
        assertThat(lottoPurchase.purchaseCount()).isEqualTo(500);
    }
}
