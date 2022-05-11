package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.constants.LottoErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
}
