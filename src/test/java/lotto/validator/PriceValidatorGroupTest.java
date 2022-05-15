package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.exception.ExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("구매금액 validator group 에 대한 테스트")
class PriceValidatorGroupTest {

    private final PriceValidatorGroup priceValidatorGroup = PriceValidatorGroup.getInstance();

    @DisplayName("싱글톤 테스트 - 싱글톤 객체는 여러번 생성해도 같은 객체이어야 한다")
    @Test
    void singleton_test() {
        PriceValidatorGroup validatorGroup = PriceValidatorGroup.getInstance();
        PriceValidatorGroup validatorGroup_2 = PriceValidatorGroup.getInstance();
        PriceValidatorGroup validatorGroup_3 = PriceValidatorGroup.getInstance();

        assertEquals(validatorGroup, validatorGroup_2);
        assertEquals(validatorGroup, validatorGroup_3);
        assertEquals(validatorGroup_2, validatorGroup_3);
    }

    @DisplayName("로또금액 이하의 금액을 전달하면 금액에 대한 에러메시지가 발생해야 한다")
    @Test
    void price_less_than_test() {
        int given = 500;

        assertThatThrownBy(() -> {
            priceValidatorGroup.validate(given);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.LESS_THAN_LOTTO_PRICE.getMessage());
    }

    @DisplayName("로또가격에 맞지 않는 단위의 금액을 전달하면 단위에 대한 에러메시지가 발생해야 한다")
    @Test
    void price_unit_test() {
        int given = 2500;

        assertThatThrownBy(() -> {
            priceValidatorGroup.validate(given);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.NOT_MATCHED_UNIT_PRICE.getMessage());
    }
}
