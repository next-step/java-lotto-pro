package lotto.service;

import static lotto.domain.message.ErrorMessage.INVALID_LOTTO_NUMBERS;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberValidatorTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    @DisplayName("번호가 1보다 작거나 45보다 크면 IllegalrgumentException을 발생시킨다")
    void when_number_is_invalid_should_throw_IllegalArgumentException(final int number) {
        // when and then
        Assertions.assertThatThrownBy(() -> LottoNumberValidator.checkRangeOfNumber(number, INVALID_LOTTO_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
