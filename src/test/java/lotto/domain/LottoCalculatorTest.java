package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

@DisplayName("LottoCalculator 테스트")
public class LottoCalculatorTest {

    private PurchaseAmount purchaseAmount;

    @BeforeEach
    void setUp() {
        purchaseAmount = new PurchaseAmount(10_000);
    }

    @Test
    @DisplayName("구입된 로또 개수를 반환한다.")
    void getLottosSize() {
        // given
        LottoCalculator lottoCalculator= new LottoCalculator(purchaseAmount);

        // when
        int lottosSize = lottoCalculator.getLottosSize();

        // then
        assertThat(lottosSize).isEqualTo(purchaseAmount.getQuantity());
    }

    @Test
    @DisplayName("로또 수익률을 반환한다.")
    void getProceedsRate() {
        // given
        WinningResults winningResults = new WinningResults(Collections.singletonList(WinningResult.FIFTH));
        LottoCalculator lottoCalculator= new LottoCalculator(purchaseAmount, winningResults);

        // when
        float proceedsRate = lottoCalculator.getProceedsRate();

        // then
        assertThat(proceedsRate).isEqualTo(0.5F);
    }
}
