package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPurchaseTest {
    @Test
    @DisplayName("구매한 로또의 갯수를 확인한다.")
    void 테스트_구매한로또_갯수_확인() {
        LottoPurchase lottoPurchase = new LottoPurchase(5);
        assertThat(lottoPurchase.issuedLottoCount()).isEqualTo(5);
    }
}
