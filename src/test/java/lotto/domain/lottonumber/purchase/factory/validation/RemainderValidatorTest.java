package lotto.domain.lottonumber.purchase.factory.validation;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RemainderValidatorTest {

    PurchaseValidator validator = new RemainderValidator();

    @ParameterizedTest
    @DisplayName("1000원으로 나누어 떨어지면 성공 아니면 EX 발생")
    @CsvSource(value = {"1000:500", "5000:-1"}, delimiter = ':')
    void remain(String success, String ex) {
        assertThatNoException().isThrownBy(() -> validator.validate(success));
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate(ex))
                .withMessageContaining("[ERROR]");
    }
}
