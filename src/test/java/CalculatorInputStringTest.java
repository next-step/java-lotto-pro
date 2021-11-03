import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
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
}
