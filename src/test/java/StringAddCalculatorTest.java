import static org.assertj.core.api.Assertions.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import exception.InvalidDelimiterFormat;
import exception.NegativeIntegerValueException;

public class StringAddCalculatorTest {

	@ParameterizedTest
	@NullAndEmptySource
	public void splitAndSum_null_또는_빈문자(String text) {
		int result = StringAddCalculator.splitAndSum(text);
		assertThat(result).isEqualTo(0);
	}

	@ParameterizedTest
	@CsvSource(value = {"0=0", "1=1", "10=10", "5435=5435"}, delimiter = '=')
	public void splitAndSum_숫자하나(String text, int expectedSum) {
		int result = StringAddCalculator.splitAndSum(text);
		assertThat(result).isEqualTo(expectedSum);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2=3", "0,1=1", "1,543=544"}, delimiter = '=')
	public void splitAndSum_쉼표구분자(String text, int expectedSum) {
		int result = StringAddCalculator.splitAndSum(text);
		assertThat(result).isEqualTo(expectedSum);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2:3=6", "0,1:1=2", "1,543:544=1088"}, delimiter = '=')
	public void splitAndSum_쉼표_또는_콜론_구분자(String text, int expectedSum) {
		int result = StringAddCalculator.splitAndSum(text);
		assertThat(result).isEqualTo(expectedSum);
	}

	@Test
	public void splitAndSum_custom_구분자() {
		int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1,2,3"})
	public void splitAndSum_negative(String text) {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum(text))
			.isInstanceOf(NegativeIntegerValueException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,2f,3", "##,1,2,3"})
	public void splitAndSum_숫자자리에_문자포함_오류(String text) {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum(text))
			.isInstanceOf(NumberFormatException.class);
	}

	@Test
	public void splitAndSum_커스텀구분자_두자리이상() {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("//#$\n1,2,3"))
			.isInstanceOf(InvalidDelimiterFormat.class);
	}

	@Test
	public void splitAndSum_커스텀구분자_empty() {
		assertThatThrownBy(() -> {
			StringAddCalculator.splitAndSum("//\n1,2,3");
		}).isInstanceOf(InvalidDelimiterFormat.class);
	}

	@Test
	public void splitAndSum_커스텀구분자_포함인경우_덧셈할_문자열은_empty() {
		int result = StringAddCalculator.splitAndSum("//;\n");
		assertThat(result).isEqualTo(0);
	}
}