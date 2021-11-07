package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("LottoCalculator 테스트")
public class LottoCalculatorTest {

    @Test
    @DisplayName("구입된 로또 개수를 반환한다.")
    void getLottosSize() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(10_000);
        LottoCalculator lottoCalculator = new LottoCalculator(purchaseAmount);

        // when
        int lottosSize = lottoCalculator.getLottosSize();

        // then
        assertThat(lottosSize).isEqualTo(purchaseAmount.getQuantity());
    }
}
