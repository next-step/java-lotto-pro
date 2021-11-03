package utility;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.platform.commons.util.ReflectionUtils;

@DisplayName("문자열 덧셈 계산기")
class StringAddCalculatorTest {

	@Test
	@DisplayName("인스턴스화 방지")
	void instance_thrownAssertionError() {
		assertThatExceptionOfType(AssertionError.class)
			.isThrownBy(() -> ReflectionUtils.newInstance(StringAddCalculator.class));
	}

	@ParameterizedTest(name = "{displayName}[{index}] {0} is always returned zero")
	@DisplayName("공백 또는 null 일 경우 항상 0")
	@NullAndEmptySource
	void splitAndSum_nullOrEmpty(String target) {
		//when
		int result = StringAddCalculator.splitAndSum(target);

		//then
		assertThat(result)
			.isZero();
	}

	@Test
	@DisplayName("한개의 숫자 더하기")
	void splitAndSum_onlyOneNumber() {
		//given, when
		int result = StringAddCalculator.splitAndSum("1");

		//then
		assertThat(result)
			.isEqualTo(1);
	}

	@Test
	@DisplayName("쉽표 구분자 포함")
	void splitAndSum_commaDelimiter() {
		//given, when
		int result = StringAddCalculator.splitAndSum("1,2");

		//then
		assertThat(result)
			.isEqualTo(3);
	}

	@Test
	@DisplayName("쉽표와 콜론 구분자 포함")
	void splitAndSum_commaAndColonDelimiter() {
		//given, when
		int result = StringAddCalculator.splitAndSum("1,2:3");

		//then
		assertThat(result)
			.isEqualTo(6);
	}

	@Test
	@DisplayName("사용자 정의 구분자 포함")
	void splitAndSum_customDelimiter() {
		//given, when
		int result = StringAddCalculator.splitAndSum("//;\n1;2;3");

		//then
		assertThat(result)
			.isEqualTo(6);
	}

	@Test
	@DisplayName("음수 포함된 경우 RuntimeException 발생")
	void splitAndSum_negative_thrownRuntimeException() {
		//given, when
		ThrowingCallable callWithNegativeNumber = () -> StringAddCalculator.splitAndSum("-1,2,3");

		//then
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(callWithNegativeNumber);
	}
}
