package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.validator.PriceValidator;
import lotto.exception.ExceptionType;
import lotto.domain.validator.impl.PriceLessThanValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("금액이 낮은 케이스에 대한 테스트")
class PriceLessThanValidatorTest {

    @DisplayName("지불한 금액이 로또 가격보다 낮다면 예외가 발생해야 한다")
    @ParameterizedTest
    @ValueSource(ints = {200, 990, 0, 500})
    void price_less_than_test(int input) {
        PriceValidator priceValidator = new PriceLessThanValidator();
        assertThatThrownBy(() -> {
            priceValidator.validate(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.LESS_THAN_LOTTO_PRICE.getMessage());
    }
}
