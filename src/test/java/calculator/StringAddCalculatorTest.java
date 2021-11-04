package calculator;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringAddCalculatorTest {
	private static final String EXCEPTION_MESSAGE = "양의 숫자만 입력 가능합니다.";

	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환한다.")
	public void splitAndSum_null_or_empty_return_0(String input) {
		assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(0);
	}

	@Test
	@DisplayName("숫자 하나로 이루어진 문자열(e.g. \"1\")인 경우 해당 숫자를 반환한다.")
	public void splitAndSum_숫자하나()  {
		int result = StringAddCalculator.splitAndSum("1");
		assertThat(result).isEqualTo(1);
	}

	@Test
	@DisplayName("',' 구분자로 문자열 1,2를 분리하여 더한 값 3을 반환한다.")
	public void splitAndSum_쉼표구분자()  {
		int result = StringAddCalculator.splitAndSum("1,2");
		assertThat(result).isEqualTo(3);
	}

	@Test
	@DisplayName("',' 또는 ':' 구분자로 문자열 1,2:3을 분리하여 더한 값 6을 반환한다.")
	public void splitAndSum_쉼표_또는_콜론_구분자()  {
		int result = StringAddCalculator.splitAndSum("1,2:3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	@DisplayName("';' 구분자로 문자열 1;2;3을 분리하여 더한 값 6을 반환한다.")
	public void splitAndSum_custom_구분자()  {
		int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	@DisplayName("-1,2,3 문자열 입력 시 양의 정수만 입력 가능하다는 RuntimeException 반환한다.")
	public void splitAndSum_negative()  {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("1,d2,3 문자열 입력 시 양의 정수만 입력 가능하다는 RuntimeException 반환한다.")
	public void splitAndSum_영문자()  {
	    assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1,d2,3"))
			.isInstanceOf(RuntimeException.class).hasMessage(EXCEPTION_MESSAGE);
	}

	@Test
	@DisplayName("Given_1,다2,3 문자열 입력 When_문자열을 분리하여 더하도록 한다 Then_한글이 입력되었으므로 양의 정수만 입력가능하다는 RuntimeException을 반환한다.")
	public void splitAndSum_한글()  {
		//Given
		String input = "1,다2,3";
		//When
		ThrowableAssert.ThrowingCallable throwingCallable = () -> StringAddCalculator.splitAndSum(input);
		//Then
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(throwingCallable)
			.withMessage(EXCEPTION_MESSAGE);
	}

	@DisplayName("여러케이스 실패")
	@ParameterizedTest
	@ValueSource(strings = {"2,e,32", "-2", "test", "223220]", "2:3:-10"})
	public void splitAndSum_여러케이스_실패(String input)  {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
			.isInstanceOf(RuntimeException.class).hasMessage(EXCEPTION_MESSAGE);
	}

	@DisplayName("여러케이스 성공")
	@ParameterizedTest
	@CsvSource(value = {"2,3,5;10", "4,10:7;21", "1;1", ";0"}, delimiter = ';')
	public void splitAndSum_여러케이스_성공(String input, int expected) {
		int result = StringAddCalculator.splitAndSum(input);
		assertThat(result).isEqualTo(expected);
	}

}