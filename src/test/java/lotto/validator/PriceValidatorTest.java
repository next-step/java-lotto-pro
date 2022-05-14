package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 구매 금액에 대한 테스트")
class PriceValidatorTest {

    private PriceValidatorGroup 로또_금액_validator = PriceValidatorGroup.getInstance();

    @DisplayName("구매금액이 천원 미만이면 IllegalArgumentException 이 발생해야 한다")
    @ParameterizedTest
    @ValueSource(ints = {500, -2000, 0, 990})
    void lotto_price_test(int 구매_금액) {
        assertThatThrownBy(() -> {
            로또_금액_validator.validate(구매_금액);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.LESS_THAN_LOTTO_PRICE.getMessage());
    }

    @DisplayName("구매금액이 천원단위가 아니면 IllegalArgumentException 이 발생해야 한다")
    @ParameterizedTest
    @ValueSource(ints = {1100, 15530, 2500, 35300})
    void lotto_price_test2(int 구매_금액) {
        assertThatThrownBy(() -> {
            로또_금액_validator.validate(구매_금액);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.NOT_MATCHED_UNIT_PRICE.getMessage());
    }
}
