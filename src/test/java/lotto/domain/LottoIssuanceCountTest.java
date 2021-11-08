package lotto.domain;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoIssuanceCountTest {

    @DisplayName("1000원당 로또 1장")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "10000:10", "100000:100"}, delimiter = ':')
    void oneLottoPerOneThousandWon(int purchaseAmount, int lottoIssuanceCount) {
        assertThat(LottoIssuanceCount.issuanceNumberCalculation(new Money(purchaseAmount))).isEqualTo(new LottoIssuanceCount(lottoIssuanceCount));
    }

    @DisplayName("구매금액이 1000원 단위가 아닐 시 예외")
    @ParameterizedTest
    @ValueSource(ints = {0, 1230, 3500, 5700, 13400})
    void purchaseAmountNotOneThousandWonUnitExceptionTest(int invalidPurchaseAmount) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Money(invalidPurchaseAmount);
        }).withMessage(ErrorMessage.PURCHASE_AMOUNT_NOT_ONE_THOUSAND_WON.getMessage());
    }
}
