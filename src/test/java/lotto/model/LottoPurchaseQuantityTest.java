package lotto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.constants.LottoErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoPurchaseQuantityTest {

    @ParameterizedTest(name = "NULL이거나 EMPTY인 값({0})을 입력받으면 IllegalArgumentException이 발생")
    @NullAndEmptySource
    void inputNullAndEmptyValue(String invalidValue) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoPurchaseQuantity(invalidValue))
                .withMessage(LottoErrorMessage.INVALID_MONEY_FORMAT);
    }

    @ParameterizedTest(name = "숫자가 아닌 값({0})을 입력받으면 IllegalArgumentException이 발생")
    @ValueSource(strings = {"mond", "1m2o3n4d", "1234;"})
    void inputStringValue(String invalidValue) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoPurchaseQuantity(invalidValue))
                .withMessage(LottoErrorMessage.INVALID_MONEY_FORMAT);
    }

    @Test
    @DisplayName("음수를 입력받으면 IllegalArgumentException이 발생")
    void inputNegativeValue() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoPurchaseQuantity("-5"))
                .withMessage(LottoErrorMessage.INVALID_MONEY_FORMAT);
    }

    @Test
    @DisplayName("로또 가격보다 작은 값을 입력받으면 IllegalArgumentException이 발생")
    void inputValueLessThanLottoPrice() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoPurchaseQuantity("900"))
                .withMessage(LottoErrorMessage.MONEY_LESS_THAN_PRICE);
    }

    @ParameterizedTest(name = "입력받은 금액{0}은 로또 {1}장으로 반환")
    @CsvSource(value = {"1500:1", "20000:20", "35100:35"}, delimiter = ':')
    void inputValidValue(String input, int expected) {
        LottoPurchaseQuantity lottoPurchaseQuantity = new LottoPurchaseQuantity(input);

        assertEquals(expected, lottoPurchaseQuantity.getQuantity());
    }
}
