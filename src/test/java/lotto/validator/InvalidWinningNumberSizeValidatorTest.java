package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.validator.LottoNumbersValidator;
import lotto.exception.ExceptionType;
import lotto.domain.validator.impl.InvalidLottoNumberSizeValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("당첨번호의 크기에 대한 테스트")
class InvalidWinningNumberSizeValidatorTest {

    @DisplayName("당첨번호가 1 부터 45 사이의 값이 아니라면 예외가 발생해야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,51", "5,1,12,13,44,60", "0,45,23,18,11,7"})
    void invalid_number_test(String input) {
        LottoNumbersValidator validator = new InvalidLottoNumberSizeValidator();
        assertThatThrownBy(() -> {
            validator.validate(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.INVALID_NUMBER_SIZE.getMessage());
    }
}
