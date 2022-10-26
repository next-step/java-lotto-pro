package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NumberValidatorTest {

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""})
    public void nullOrEmptyTest(String given){
        //when & then
        assertTrue(NumberValidator.isEmpty(given));
    }

    @ParameterizedTest
    @ValueSource(strings = {"d","-1"})
    public void validateNumber(String numberFormatString){
        //when & then
        assertThatThrownBy(
                () -> {
                    NumberValidator.validateNumber(numberFormatString);
                }
        ).isInstanceOf(IllegalArgumentException.class)
         .hasMessageContaining("[ERROR]");
    }
}