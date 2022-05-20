package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.validator.LottoNumbersValidator;
import lotto.exception.ExceptionType;
import lotto.domain.validator.impl.OverlapLottoNumbersValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("당첨번호 중복 테스트")
class OverlapLottoNumbersValidatorTest {

    @DisplayName("당첨번호가 중복이 존재한다면 예외가 발생해야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,2,4,5,23", "5,1,13,13,44,45", "5,45,23,18,11,11"})
    void invalid_number_test(String input) {
        LottoNumbersValidator validator = new OverlapLottoNumbersValidator();
        assertThatThrownBy(() -> {
            validator.validate(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.IS_NOT_OVERLAP_WINNING_NUMBER.getMessage());
    }
}
