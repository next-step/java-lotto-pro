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
    void ONE_NUMBER_TO_ONE_NUMBER(String input) throws Exception {
        Numbers numbers = new Numbers();
        numbers.add(new Number(input));
        assertThat(numbers).isEqualTo(StringSeparator.split(input));
    }

    static Stream<Arguments> ONE_NUMBER() {
        return Stream.of(
                Arguments.of("0"),
                Arguments.of("10"),
                Arguments.of("999")
        );
    }

    @DisplayName("쉼표_구분자로_숫자_분리")
    @Test
    void COMMA_SPLIT() throws Exception {
        Numbers numbers = new Numbers();
        numbers.add(new Number("1"));
        numbers.add(new Number("2"));
        assertThat(numbers).isEqualTo(StringSeparator.split("1,2"));
    }

    @DisplayName("쉼표_또는_콜론_구분자로_숫자_분리")
    @Test
    void COMMA_OR_COLON_SPLIT() throws Exception {
        Numbers numbers = new Numbers();
        numbers.add(new Number("1"));
        numbers.add(new Number("2"));
        numbers.add(new Number("3"));
        assertThat(numbers).isEqualTo(StringSeparator.split("1,2:3"));
    }

    @DisplayName("커스텀_구분자로_숫자_분리")
    @Test
    void CUSTOM_SPLIT() throws Exception {
        Numbers numbers = new Numbers();
        numbers.add(new Number("1"));
        numbers.add(new Number("2"));
        numbers.add(new Number("3"));
        assertThat(numbers).isEqualTo(StringSeparator.split("//;\n1;2;3"));
    }
}
