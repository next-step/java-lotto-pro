package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringSeparatorTest {
    @DisplayName("숫자_하나만_분리")
    @ParameterizedTest
    @MethodSource("ONE_NUMBER")
    void ONE_NUMBER_TO_ONE_NUMBER(String input, String[] output) throws Exception {
        assertThat(output).isEqualTo(StringSeparator.split(input));
    }

    static Stream<Arguments> ONE_NUMBER() {
        return Stream.of(
                Arguments.of("0", new String[]{"0"}),
                Arguments.of("10", new String[]{"10"}),
                Arguments.of("999", new String[]{"999"})
        );
    }

    @DisplayName("쉼표_구분자로_숫자_분리")
    @Test
    void COMMA_SPLIT() throws Exception {
        assertThat(new String[]{"1", "2"}).isEqualTo(StringSeparator.split("1,2"));
    }

    @DisplayName("쉼표_또는_콜론_구분자로_숫자_분리")
    @Test
    void COMMA_OR_COLON_SPLIT() throws Exception {
        assertThat(new String[]{"1", "2", "3"}).isEqualTo(StringSeparator.split("1,2:3"));
    }

    @DisplayName("커스텀_구분자로_숫자_분리")
    @Test
    void CUSTOM_SPLIT() throws Exception {
        assertThat(new String[]{"1", "2", "3"}).isEqualTo(StringSeparator.split("//;\n1;2;3"));
    }
}
