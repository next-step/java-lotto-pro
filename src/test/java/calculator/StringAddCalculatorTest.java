package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAddCalculatorTest {

	@ParameterizedTest
	@NullAndEmptySource
	void splitAndSum_null_또는_빈문자(String text) {
		int result = StringAddCalculator.splitAndSum(text);
		assertThat(result).isEqualTo(0);
	}

	@Test
	void splitAndSum_숫자_하나() {
		assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
	}

	@Test
	void splitAndSum_음수() {
		assertThrows(RuntimeException.class, () -> {
			StringAddCalculator.splitAndSum("-1");
		});
	}

	@ParameterizedTest
	@ValueSource(strings = { "abc", "1,b", "#" })
	void splitAndSum_숫자이외의값(String text) {
		assertThrows(RuntimeException.class, () -> {
			StringAddCalculator.splitAndSum(text);
		});
	}

	@ParameterizedTest
	@ValueSource(strings = { "1,2:3", "1,2,3", "1:2:3" })
	void splitText_문자분리(String text) {
		assertThat(StringAddCalculator.splitText(text)).containsExactly("1", "2", "3");
	}

	@ParameterizedTest
	@CsvSource(value = { "1,2:3=6", "3,4,5=12", "6:7=13" }, delimiter = '=')
	void splitAndSum_기본_구분자_합(String text, int expected) {
		assertThat(StringAddCalculator.splitAndSum(text)).isEqualTo(expected);
	}

}
