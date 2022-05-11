package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("StringAdditionCalculator 클래스")
public class StringAdditionCalculatorTest {

    @Test
    void addAllDelimiterString_With_Comma() {
        final int result = StringAdditionCalculator.addAllDelimiterString("2,4,5");
        assertThat(result).isEqualTo(11);
    }

    @Test
    void addAllDelimiterString_With_Colon() {
        final int result = StringAdditionCalculator.addAllDelimiterString("1:2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void addAllDelimiterString_With_Comma_And_Colon() {
        final int result = StringAdditionCalculator.addAllDelimiterString("3:6,7");
        assertThat(result).isEqualTo(16);
    }

    @Test
    void addAllDelimiterString_With_Custom_Delimiter() {
        final int result = StringAdditionCalculator.addAllDelimiterString("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void addAllDelimiterString_Throw_RuntimeException_When_Number_Is_Minus() {
        assertThatThrownBy(() -> StringAdditionCalculator.addAllDelimiterString("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void addAllDelimiterString_Throw_RuntimeException_When_Not_A_Number() {
        assertThatThrownBy(() -> StringAdditionCalculator.addAllDelimiterString("a,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

}
