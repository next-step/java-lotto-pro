package util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringAddCalculatorTest {

    @Test
    void splitAndSum_null_또는_빈문자() throws MyOwnRuntimeException {
        int result = StringAddCalculator.splitAndSum("");
        assertThat(result).isZero();

        result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isZero();
    }

    @Test
    void splitAndSum_숫자하나() throws MyOwnRuntimeException {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void splitAndSum_쉼표구분자() throws MyOwnRuntimeException {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분자() throws MyOwnRuntimeException {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_custom_구분자() throws MyOwnRuntimeException {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_negative() {
        Exception exception = assertThrows(RuntimeException.class, () -> StringAddCalculator.splitAndSum("-1,2,3"));
        String expectedMessage = "For input only positive integers";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
