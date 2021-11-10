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
        PurchaseLottoAmount amount = new PurchaseLottoAmount(purchaseLottoAmount);
        Long count = amount.calculateLottoPurchaseCount(lottoPrice);

        // then
        Assertions.assertThat(count).isEqualTo(14);
    }

    @DisplayName("당첨에 따른 수익률 계산 테스트")
    @Test
    public void calculateReturnRateTest() {

        // given
        Long purchaseLottoAmount = 14_000L;
        Long totalWinningAmount = 5_000L;

        // when
        PurchaseLottoAmount amount = new PurchaseLottoAmount(purchaseLottoAmount);
        BigDecimal result = amount.calculateReturnRate(totalWinningAmount);

        // then
        Assertions.assertThat(result).isEqualTo(new BigDecimal("0.35"));
    }
}
