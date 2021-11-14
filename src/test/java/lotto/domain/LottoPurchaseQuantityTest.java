package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoPurchaseQuantityTest {

    @Test
    public void 자동의_수량이_5이다() {
        //given
        LottoPurchaseQuantity lottoPurchaseQuantity = new LottoPurchaseQuantity();
        int actual = 5;

        //when
        lottoPurchaseQuantity.addPurchaseQuantity(LottoPurchaseType.AUTO, 5);
        int expected = lottoPurchaseQuantity.findPurchaseQuantity(LottoPurchaseType.AUTO);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 수동의_수량이_5이다() {
        //given
        LottoPurchaseQuantity lottoPurchaseQuantity = new LottoPurchaseQuantity();
        int actual = 5;

        //when
        lottoPurchaseQuantity.addPurchaseQuantity(LottoPurchaseType.MANUAL, 5);
        int expected = lottoPurchaseQuantity.findPurchaseQuantity(LottoPurchaseType.MANUAL);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}