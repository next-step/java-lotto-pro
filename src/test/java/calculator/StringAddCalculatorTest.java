package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    @DisplayName("숫자_하나만_입력_결과")
    @ParameterizedTest
    @MethodSource("숫자_하나만_입력")
    void 숫자_하나만_입력_결과(String input) throws Exception {
        assertThat(Integer.parseInt(input)).isEqualTo(StringAddCalculator.splitAndSum(input));
    }

    static Stream<Arguments> 숫자_하나만_입력() {
        return Stream.of(
                Arguments.of("0"),
                Arguments.of("10"),
                Arguments.of("999")
        );
    }

    @DisplayName("쉼표_구분자로_숫자_분리_결과")
    @Test
    void 쉼표_구분자로_숫자_분리_결과() throws Exception {
        assertThat(3).isEqualTo(StringAddCalculator.splitAndSum("1,2"));
    }

    @DisplayName("쉼표_또는_콜론_구분자로_숫자_분리_결과")
    @Test
    void 쉼표_또는_콜론_구분자로_숫자_분리_결과() throws Exception {
        assertThat(6).isEqualTo(StringAddCalculator.splitAndSum("1,2:3"));
    }

    @DisplayName("커스텀_구분자로_숫자_분리_결과")
    @Test
    void 커스텀_구분자로_숫자_분리_결과() throws Exception {
        Numbers numbers = new Numbers();
        assertThat(6).isEqualTo(StringAddCalculator.splitAndSum("//;\n1;2;3"));
    }
}
