package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.validator.NumberValidator;
import lotto.domain.validator.impl.LottoNumberSizeValidator;
import lotto.exception.ExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또번호의 범위에 대한 테스트")
class LottoNumberSizeValidatorTest {

    @DisplayName("로또번호가 1 - 45 이외의 값을 전달받으면 예외가 발생해야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"0", "48", "199", "55"})
    void lotto_number_test(String given) {

        NumberValidator numberValidator = new LottoNumberSizeValidator();
        assertThatThrownBy(() -> {
            numberValidator.validate(given);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.INVALID_NUMBER_SIZE.getMessage());
    }
}
