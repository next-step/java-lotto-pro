package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringAddCalculatorTest {
	private static final String EXCEPTION_MESSAGE = "양의 숫자만 입력 가능합니다.";

	@Test
	public void splitAndSum_null_또는_빈문자() {
		int result = StringAddCalculator.splitAndSum(null);
		assertThat(result).isEqualTo(0);

		result = StringAddCalculator.splitAndSum("");
		assertThat(result).isEqualTo(0);
	}

	@Test
	public void splitAndSum_숫자하나() throws Exception {
		int result = StringAddCalculator.splitAndSum("1");
		assertThat(result).isEqualTo(1);
	}

	@Test
	public void splitAndSum_쉼표구분자() throws Exception {
		int result = StringAddCalculator.splitAndSum("1,2");
		assertThat(result).isEqualTo(3);
	}

	@Test
	public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
		int result = StringAddCalculator.splitAndSum("1,2:3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void splitAndSum_custom_구분자() throws Exception {
		int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void splitAndSum_negative() throws Exception {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	public void splitAndSum_한글() throws Exception {
	    assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1,d2,3"))
			.isInstanceOf(RuntimeException.class).hasMessage(EXCEPTION_MESSAGE);
	}

	@DisplayName("여러케이스 실패")
	@ParameterizedTest
	@ValueSource(strings = {"2,e,32", "-2", "test", "223220]", "2:3:-10"})
	public void splitAndSum_여러케이스_실패(String input) throws Exception {
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