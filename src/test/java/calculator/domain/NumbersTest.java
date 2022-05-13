package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumbersTest {
	@ParameterizedTest
	@CsvSource(value = {
		"2:2",
		"14,2,3:19",
		"4,10,222:236"
	}, delimiter = ':')
	@DisplayName("총합을 계산한다.")
	void total(String csvValue, int expected) {
		Numbers numbers = new Numbers(csvValue.split(","));
		assertThat(numbers.total()).isEqualTo(expected);
	}
}