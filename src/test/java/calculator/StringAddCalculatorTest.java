package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {
	@Test
	@DisplayName("splitAndSum_null_또는_빈문자")
	void null_or_empty_parameter_return_0() {
		int result = StringAddCalculator.splitAndSum(null);
		assertThat(result).isEqualTo(0);

		result = StringAddCalculator.splitAndSum("");
		assertThat(result).isEqualTo(0);
	}

	@Test
	@DisplayName("splitAndSum_숫자하나")
	void one_value_parameter() throws Exception {
		int result = StringAddCalculator.splitAndSum("1");
		assertThat(result).isEqualTo(1);
	}

	@Test
	@DisplayName("splitAndSum_쉼표구분자")
	void comma_delimiter_sum() throws Exception {
		int result = StringAddCalculator.splitAndSum("1,2");
		assertThat(result).isEqualTo(3);
	}

	@Test
	@DisplayName("splitAndSum_쉼표_또는_콜론_구분자")
	void comma_clone_delimiter_sum() throws Exception {
		int result = StringAddCalculator.splitAndSum("1,2:3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	@DisplayName("splitAndSum_custom_구분자")
	void custom_delimiter_sum() throws Exception {
		int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	@DisplayName("splitAndSum_negative")
	void valid_negative() throws Exception {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}
}
