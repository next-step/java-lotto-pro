package lotto.util;

import java.util.Arrays;
import java.util.stream.Stream;
import lotto.domain.message.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StringToIntegerConverterTest {
    @ParameterizedTest
    @MethodSource("errorMessages")
    @DisplayName("integer로 변경이 불가능하면 에러 메시지와 함께 IllegalArgumentException을 반환해야 한다")
    void when_cannot_convert_should_throw_IllegalArgumentException_with_error_message(final ErrorMessage errorMessage) {
        // given
        final String input = "test";

        // when and then
        Assertions.assertThatThrownBy(() -> StringToIntegerConverter.parseInt(input, errorMessage))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage.getMessage());
    }

    private static Stream<Arguments> errorMessages() {
        return Arrays.stream(ErrorMessage.values()).map(errorMessage -> Arguments.of(errorMessage));
    }
}
