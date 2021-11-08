package calculator;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAddCalculatorTest {
	@Test
	@DisplayName("입력이 null 또는 빈문자인 경우 0을 반환한다.")
	public void splitAndSum_null_또는_빈문자() {
		int result = StringAddCalculator.splitAndSum(null);
		assertThat(result).isEqualTo(0);

		result = StringAddCalculator.splitAndSum("");
		assertThat(result).isEqualTo(0);
	}

	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("입력이 null 또는 빈문자인 경우 0을 반환한다. (@NullAndEmptySource 연습)")
	public void splitAndSum_null_and_empty_source(String input) {
		int result = StringAddCalculator.splitAndSum(input);
		assertThat(result).isEqualTo(0);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "13"})
	@DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
	public void splitAndSum_숫자하나(String input) {
		int result = StringAddCalculator.splitAndSum(input);
		assertThat(result).isEqualTo(Integer.parseInt(input));
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2|3", "4,5|9", "13,2|15"}, delimiter = '|')
	@DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
	public void splitAndSum_쉼표구분자(String input, int expected) {
		int result = StringAddCalculator.splitAndSum(input);
		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2:3|6", "4,5:6|15", "2,7:3|12"}, delimiter = '|')
	@DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
	public void splitAndSum_쉼표_또는_콜론_구분자(String input, int expected) {
		int result = StringAddCalculator.splitAndSum(input);
		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@ValueSource(strings = {"//;\n1;2;3", "//#\n1#2#3", "//@\n1@2@3"})
	@DisplayName("// 와 \n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
	public void splitAndSum_custom_구분자(String input) {
		int result = StringAddCalculator.splitAndSum(input);
		assertThat(result).isEqualTo(6);
	}

	@Test
	@DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생한다.")
	public void splitAndSum_negative() {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생한다. (given-when-then 구조 분리 연습)")
	public void splitAndSum_negative_given_when_then() {
		// when then
		Assertions.assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
			.withMessage(Messages.OUT_OF_MINIMUM_NUMBER_RANGE_ERROR);

		// when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> StringAddCalculator.splitAndSum("-1,2,3");

		// then
		Assertions.assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(throwingCallable)
			.withMessageMatching(Messages.OUT_OF_MINIMUM_NUMBER_RANGE_ERROR);
	}
}
