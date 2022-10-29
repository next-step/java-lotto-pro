package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoLotteryTest {
    @Test
    @DisplayName("구매한 복권의 갯수만큼 자동 로또가 생성된다")
    void test() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount("3000");
        LottoPurchaseQuantity lottoPurchaseQuantity = LottoPurchaseQuantity.of(lottoPurchaseAmount.calculateQuantity());
        LottoLottery lottoLottery = LottoLottery.of(lottoPurchaseQuantity, new AutoNumberGenerator());
        assertThat(lottoLottery).isInstanceOf(LottoLottery.class);
    }
}
