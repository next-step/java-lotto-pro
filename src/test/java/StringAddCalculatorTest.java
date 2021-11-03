import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class StringAddCalculatorTest {

	StringAddCalculator stringAddCalculator;

	@BeforeEach
	void setup() {
		stringAddCalculator = new StringAddCalculator();
	}

	@ParameterizedTest
	@DisplayName("빈 문자열, null을 입력할 경우 0을 반환한다.")
	@MethodSource("test_splitAndSum1Parameter")
	public void test_splitAndSum1(String source, int expected) {
		assertThat(stringAddCalculator.splitAndSum(source)).isEqualTo(expected);
	}

	private static Stream<Arguments> test_splitAndSum1Parameter() {
		return Stream.of(
			Arguments.of(null, 0),
			Arguments.of("", 0)
		);
	}

	@Test
	@DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
	public void test_splitAndSum2() {
		assertThat(stringAddCalculator.splitAndSum("1")).isEqualTo(1);
	}

	@Test
	@DisplayName("숫자 두개를 컴마 구분자로 입력할 경우 각 숫자의 합을 반환한다.")
	public void test_splitAndSum3() {
		assertThat(stringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
	}

	@Test
	@DisplayName("콜론 구분자로 입력할 경우에도 각 숫자의 합을 반환한다.")
	public void test_splitAndSum4() {
		assertThat(stringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
	}

	@Test
	@DisplayName("\"//\"와 \"\\n\" 문자 사이에 커스텀 구분자를 지정할 수 있으며, 해당 구분자를 사용할 경우 두 숫자의 합을 반환한다.")
	public void test_splitAndSum5() {
		assertThat(stringAddCalculator.splitAndSum("//;\n1;2;3;4")).isEqualTo(10);
	}

	@Test
	@DisplayName("음수를 전달할 경우 IllegalArgumentException 예외가 발생한다. (예 : \"-1,2,3\")")
	public void test_splitAndSum6() {
		assertThatThrownBy(() -> {
			stringAddCalculator.splitAndSum("-1,2");
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessage(StringAddCalculator.MESSAGE_HAS_NEGATIVE_NUMBER);
	}

	@Test
	@DisplayName("문자를 전달할 경우 IllegalArgumentException 예외가 발생한다. (예 : \"-1,2,3\")")
	public void test_splitAndSum7() {
		assertThatThrownBy(() -> {
			stringAddCalculator.splitAndSum("a,2");
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessage(CalculatorInputString.MESSAGE_VALUE_IS_NOT_NUMBER_FORMAT);
	}

}
