package stringadder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AddExpressionTest {
    @ParameterizedTest
    @CsvSource(
            value = {
                    "'//;\n1;2,3:4'|;|'1;2,3:4'",
                    "'5,6:7'|null|'5,6:7'",
                    "''|null|''"
            },
            delimiter = '|',
            nullValues = {"null"})
    void 주어진_문자열에서_커스텀구분자_부분과_토큰_부분을_분리할_수_있다(
            final String value,
            final String customDelimiterPart,
            final String tokensPart
    ) {
        final AddExpression expected = new AddExpression(customDelimiterPart, tokensPart);
        final AddExpression actual = new AddExpression(value);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 토큰_뽑아내기() {
        final AddExpression expression = new AddExpression("//;\n1;2,3:4");
        final String[] tokens = expression.parseTokens();

        assertThat(tokens).containsExactly("1", "2", "3", "4");
    }
}