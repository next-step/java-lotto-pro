package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.common.exception.InvalidParamException;
import step3.domain.Amount;

public class AmountTest {

    @Test
    @DisplayName("최소금액 이하 에러 발생")
    void notEnoughAmountException() {
        assertThatExceptionOfType(InvalidParamException.class)
            .isThrownBy(() -> {
                // when
                new Amount(500);
            }) // then
            .withMessageMatching(Amount.NOT_ENOUGH_MESSAGE);
    }

    @Test
    @DisplayName("지불 금액보다 많은 로또 구매 수량 체크시 false 반환")
    void valid() {
        // when
        Amount amount = new Amount(1000);

        // then
        assertThat(amount.isBuyAvailableQuantity(2)).isFalse();
    }

}
