package nextstep.lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PurchaseLottoAmountTest {

    @DisplayName("금액에 따른 로또 수량 테스트")
    @Test
    public void calculateLottoPurchaseCountTest() {

        // given
        Long purchaseLottoAmount = 14_000L;
        Long lottoPrice = 1_000L;

        // when
        PurchaseLottoAmount purchaseLottoAmount1 = new PurchaseLottoAmount(purchaseLottoAmount, 0L);
        Long count1 = purchaseLottoAmount1.calculateAutoLottoPurchaseCount(lottoPrice);

        PurchaseLottoAmount purchaseLottoAmount2 = new PurchaseLottoAmount(purchaseLottoAmount, 1L);
        Long count2 = purchaseLottoAmount2.calculateManualLottoPurchaseCount(lottoPrice);

        // then
        Assertions.assertThat(count1).isEqualTo(14);
        Assertions.assertThat(count2).isEqualTo(1);
    }

    @DisplayName("당첨에 따른 수익률 계산 테스트")
    @Test
    public void calculateReturnRateTest() {

        // given
        Long purchaseLottoAmount = 14_000L;
        Long totalWinningAmount = 5_000L;

        // when
        PurchaseLottoAmount amount = new PurchaseLottoAmount(purchaseLottoAmount, 0L);
        BigDecimal result = amount.calculateReturnRate(totalWinningAmount);

        // then
        Assertions.assertThat(result).isEqualTo(new BigDecimal("0.35"));
    }
}
