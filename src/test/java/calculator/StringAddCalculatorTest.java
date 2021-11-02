package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringAddCalculatorTest {

	@ParameterizedTest
	@NullAndEmptySource
	void splitAndSum_null_또는_빈문자(String text) {
		int result = StringAddCalculator.splitAndSum(text);
		assertThat(result).isEqualTo(0);
	}

}
