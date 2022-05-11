package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {
	@DisplayName("빈 문자열 또는 null을 입력할 경우 0을 반환한다")
	@ParameterizedTest
	@NullAndEmptySource
	void calculate_empty_null(String string) {
		assertThat(StringAddCalculator.splitAndSum(string)).isZero();
	}
}
