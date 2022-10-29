package lotto.domain.lottonumber.purchase.validation;

import static lotto.domain.lottonumber.purchase.validation.PurchaseValidator.ERROR_NUMBER_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberValidatorTest {

    PurchaseValidator validator = new NumberValidator();

    @ParameterizedTest
    @CsvSource(value = {"1:a"}, delimiter = ':')
    void 숫자면_통과_아니면_EX(String success, String ex) {
        assertThatNoException().isThrownBy(() -> validator.validate(success));
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate(ex))
                .withMessageContaining(ERROR_NUMBER_MESSAGE);
    }
}
