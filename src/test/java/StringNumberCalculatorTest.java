import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringNumberCalculatorTest {

    @Test
    void nullOrEmpty() {
        assertThat(StringNumberCalculator.splitAndSum(null)).isEqualTo(0);
        assertThat(StringNumberCalculator.splitAndSum("")).isEqualTo(0);
        assertThat(StringNumberCalculator.splitAndSum(" ")).isEqualTo(0);
    }

    @Test
    void blank() {
        assertThat(StringNumberCalculator.splitAndSum(" ")).isEqualTo(0);
        assertThat(StringNumberCalculator.splitAndSum("  ")).isEqualTo(0);
        assertThat(StringNumberCalculator.splitAndSum("   ")).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"O", "TDD", "1, TDD", "TDD, 1"})
    void containsNonNumeric(final String input) {
        assertThatThrownBy(() -> StringNumberCalculator.splitAndSum(input))
            .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-10", "-5", "-1", "-1, 2, 3", "2, -1, 3", "2, 3, -1"})
    void containsMinus(final String input) {
        assertThatThrownBy(() -> StringNumberCalculator.splitAndSum(input))
            .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "0, 0", "0, 0, 0"})
    void zero(final String input) {
        assertThat(StringNumberCalculator.splitAndSum(input)).isEqualTo(0);
    }

    @Test
    void containsZero() {
        assertThat(StringNumberCalculator.splitAndSum("0, 1, 2")).isEqualTo(3);
        assertThat(StringNumberCalculator.splitAndSum("1, 0, 2")).isEqualTo(3);
        assertThat(StringNumberCalculator.splitAndSum("1, 2, 0")).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "10"})
    void onePositiveNumber(final String value) {
        assertThat(StringNumberCalculator.splitAndSum(value)).isEqualTo(Integer.parseInt(value));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "2,1:3", "5,10:15", "10,5:15", "1,2,3:6", "3,2,1:6", "1,2,3,4:10",
        "4,3,2,1:10"}, delimiter = ':')
    void multiplePositiveNumbers_commaDelimiter(final String input, final int expected) {
        assertThat(StringNumberCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2,3", "2:1,3", "5:10,15", "10:5,15", "1:2:3,6", "3:2:1,6", "1:2:3:4,10",
        "4:3:2:1,10"}, delimiter = ',')
    void multiplePositiveNumbers_colonDelimiter(final String input, final int expected) {
        assertThat(StringNumberCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {";", "!"})
    void multiplePositiveNumbers_customDelimiter(final String customDelimiter) {
        final String input = String.format("//%s\n1%s2%s3", customDelimiter, customDelimiter,
            customDelimiter);
        final String reversedInput = String.format("//%s\n3%s2%s1", customDelimiter,
            customDelimiter, customDelimiter);
        assertThat(StringNumberCalculator.splitAndSum(input)).isEqualTo(6);
        assertThat(StringNumberCalculator.splitAndSum(reversedInput)).isEqualTo(6);
    }

    @Test
    void multiplePositiveNumbers_customDelimiter_alphabet() {
        final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < alphabet.length(); i++) {
            final String customDelimiter = String.valueOf(alphabet.charAt(i));

            final String input = String.format("//%s\n1%s2%s3", customDelimiter, customDelimiter,
                customDelimiter);
            final String reversedInput = String.format("//%s\n3%s2%s1", customDelimiter,
                customDelimiter, customDelimiter);

            assertThat(StringNumberCalculator.splitAndSum(input)).isEqualTo(6);
            assertThat(StringNumberCalculator.splitAndSum(reversedInput)).isEqualTo(6);
        }
    }
}
