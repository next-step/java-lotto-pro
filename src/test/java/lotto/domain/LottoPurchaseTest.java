package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.ThrowableAssert.ThrowingCallable;

class LottoPurchaseTest {

    @Test
    public void 로또를_5장_구매한다() {
        //given
        int purchaseAmount = 5000;

        //when
        LottoPurchase lottoPurchase = new LottoPurchase(purchaseAmount);

        //then
        assertThat(lottoPurchase.getPurchaseQuantity()).isEqualTo(5);
    }

    @Test
    public void 로또를_구매할_수_없다() {
        //given
        int purchaseAmount = 999;

        //when
        ThrowingCallable throwingCallable = () -> new LottoPurchase(purchaseAmount);

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(throwingCallable);
    }
}