import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorInputStringTest {

	@ParameterizedTest
	@DisplayName("빈 문자열, null을 입력하면 true 반환")
	@MethodSource("testCalculatorInputString_isEmpty1_Parameter")
	public void testCalculatorInputString_isEmpty1(String source, boolean expected) {
		CalculatorInputString inputString = new CalculatorInputString(source);
		assertThat(inputString.isEmpty()).isEqualTo(expected);
	}

	private static Stream<Arguments> testCalculatorInputString_isEmpty1_Parameter() {
		return Stream.of(
			Arguments.of("", true),
			Arguments.of(null, true)
		);
	}

	@Test
	@DisplayName("주어진 문자열을 이용해 CalculatorNumbers 반환")
	public void test_toCalculatorNumbers1() {
		CalculatorInputString inputString = new CalculatorInputString("1,2:3");

		assertThat(inputString.toCalculateNumbers()).isInstanceOf(CalculatorNumbers.class);
	}

	@Test
	@DisplayName("주어진 문자열에 숫자가 아닌 값이 포함되있으면 throw IllegalArgumentException")
	public void test_toCalculatorNumbers2() {
		CalculatorInputString inputString = new CalculatorInputString("A,2:3");

		assertThatThrownBy(() -> inputString.toCalculateNumbers())
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(CalculatorInputString.MESSAGE_VALUE_IS_NOT_NUMBER_FORMAT);
	}
}
