package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ExceptionType;
import lotto.validator.impl.PriceUnitMatchedValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("지불한 금액의 단위에 대한 테스트")
class PriceUnitMatchedValidatorTest {

    @DisplayName("지불한 금액이 로또 1개의 가격 단위가 아니라면 에외가 발생해야 한다")
    @ParameterizedTest
    @ValueSource(ints = {1500, 23200, 50500, 23400})
    void price_unit_test(int input) {
        PriceValidator priceValidator = new PriceUnitMatchedValidator();
        assertThatThrownBy(() -> {
            priceValidator.validate(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.NOT_MATCHED_UNIT_PRICE.getMessage());
    }
}
