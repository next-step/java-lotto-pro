import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorNumbersTest {

	@ParameterizedTest
	@DisplayName("음수가 포함되어 있을 경우 true 반환")
	@MethodSource("test_containExceptionalParameter")
	public void test_containExceptional(boolean expected, List<Integer> integerList) {
		CalculatorNumbers calculatorNumbers = new CalculatorNumbers(integerList);

		assertThat(calculatorNumbers.containExceptional()).isEqualTo(expected);
	}

	private static Stream<Arguments> test_containExceptionalParameter() {
		return Stream.of(
			Arguments.of(false, Arrays.asList(0, 1, 2)),
			Arguments.of(true, Arrays.asList(-1, 0, 1))
		);
	}

	@ParameterizedTest
	@DisplayName("숫자가 하나뿐일 경우 true 반환")
	@MethodSource("test_hasSingleNumberParameter")
	public void test_hasSingleNumber(boolean expected, List<Integer> integerList) {
		CalculatorNumbers calculatorNumbers = new CalculatorNumbers(integerList);

		assertThat(calculatorNumbers.hasSingleNumber()).isEqualTo(expected);
	}

	private static Stream<Arguments> test_hasSingleNumberParameter() {
		return Stream.of(
			Arguments.of(false, Arrays.asList(0, 1, 2)),
			Arguments.of(false, new ArrayList<>()),
			Arguments.of(true, Collections.singletonList(1))
		);
	}
}
