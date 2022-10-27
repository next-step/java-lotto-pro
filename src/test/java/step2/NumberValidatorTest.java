package step2;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "a,2,3", "%,2,3"})
    public void validateNumber_exception(String input) throws Exception {
        String[] inputArray = input.split(",");
        assertThatThrownBy(() -> NumberValidator.validateNumbersPositive(inputArray))
                .isInstanceOf(IllegalArgumentException.class);
    }

}