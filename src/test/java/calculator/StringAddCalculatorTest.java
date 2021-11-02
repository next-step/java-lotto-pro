package calculator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAddCalculatorTest {

	static List<Arguments> nullOrBlankStrings() {
		return Lists.list(
			arguments(null, 0),
			arguments("", 0));
	}

	@ParameterizedTest
	@MethodSource("nullOrBlankStrings")
	@DisplayName("빈문자 또는 null을 입력하면, 0을 반환해야 한다")
	public void splitAndSum_null_또는_빈문자(String input, int expected) {
		// when
		int result = StringAddCalculator.splitAndSum(input);

		// then
		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1", "2021", "11", "2", "0"})
	@DisplayName("문자열로 된 한 숫자를 입력하면, 입력한 숫자를 반횐햐야 한다")
	public void splitAndSum_숫자하나(String input) throws Exception {
		// given
		int expected = Integer.parseInt(input);

		// when
		int result = StringAddCalculator.splitAndSum(input);

		// then
		assertThat(result).isEqualTo(expected);

	}

	@Test
	@DisplayName("구분자로 쉼표를 입력하면, 덧셈 값을 반환해야 한다")
	public void splitAndSum_쉼표구분자() throws Exception {
		int result = StringAddCalculator.splitAndSum("1,2");
		assertThat(result).isEqualTo(3);
	}

	@Test
	@DisplayName("구분자로 쉼표와 콜론를 입력하면, 덧셈 값을 반환해야 한다")
	public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
		int result = StringAddCalculator.splitAndSum("1,2:3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	@DisplayName("커스텀 구분자를 입력하면, 덧셈값을 반환해야 한다")
	public void splitAndSum_custom_구분자() throws Exception {
		int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	@DisplayName("음수를 포함한 값을 입력하면, RuntimeException이 발생해야 한다")
	public void splitAndSum_negative() throws Exception {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}
}
