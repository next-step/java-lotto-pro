package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringToNumbersConverterTest {
    @ParameterizedTest
    @ValueSource(strings = {"1 ! 2 a 3 가 4 @ 5 # 6", "a, b,c,d,e ,f", "1 , 2 , 3 , 4, 5 , a"})
    @DisplayName("숫자, 컴마, 공백 외의 문자를 가진 문자열이면 IllegalArgumentException을 발생시킨다")
    void when_numbersString_cannot_be_converted_to_list_should_throw_IllegalArgumentException(
            final String numbersString) {
        // when and then
        assertThatThrownBy(() -> StringToNumbersConverter.convert(numbersString))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
