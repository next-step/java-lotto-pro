package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

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
	@ValueSource(strings = {"1", "2", "13"})
	@DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
	public void splitAndSum_숫자하나(String input) throws Exception {
		int result = StringAddCalculator.splitAndSum(input);
		assertThat(result).isEqualTo(Integer.parseInt(input));
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2|3", "4,5|9", "13,2|15"}, delimiter = '|')
	@DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
	public void splitAndSum_쉼표구분자(String input, int expected) throws Exception {
		int result = StringAddCalculator.splitAndSum(input);
		assertThat(result).isEqualTo(expected);
	}
}
