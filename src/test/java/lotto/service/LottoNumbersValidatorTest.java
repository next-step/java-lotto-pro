package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoNumbersValidatorTest {
    @ParameterizedTest
    @MethodSource("numbersNotHavingSixNumbers")
    @DisplayName("번호가 6개가 아니면 IllegalArgumentException을 발생시킨다")
    void when_amount_of_numbers_is_not_six_should_throw_IllegalArgumentException(final List<Integer> numbers) {
        // when and then
        Assertions.assertThatThrownBy(() -> LottoNumbersValidator.validateNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> numbersNotHavingSixNumbers() {
        return Stream.of(Arguments.of(new ArrayList<>()),
                Arguments.of(Arrays.asList(1)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
    }
}
