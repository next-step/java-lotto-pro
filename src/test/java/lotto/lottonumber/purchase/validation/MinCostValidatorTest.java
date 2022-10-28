package lotto.lottonumber.purchase.validation;

import static lotto.lottonumber.purchase.validation.PurchaseValidator.ERROR_MIN_COST_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MinCostValidatorTest {

    PurchaseValidator validator = new MinCostValidator();

    @ParameterizedTest
    @DisplayName("1000원 이상이면 통과 미만이면 EX 발생")
    @CsvSource(value = {"1000:500", "5000:-1"}, delimiter = ':')
    void minCost(String success, String ex) {
        assertThatNoException().isThrownBy(() -> validator.validate(success));
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate(ex))
                .withMessageContaining(ERROR_MIN_COST_MESSAGE);
    }
}
