package stringaddcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {
	@DisplayName("합계")
	@Test
	void sum() {
		Numbers numbers = Numbers.from(new String[] {"1", "2", "3"});
		assertThat(numbers.sum()).isEqualTo(Number.from(6));
	}

	@DisplayName("빈 Numbers 합계 0")
	@Test
	void sum_emptyNumbers() {
		Numbers emptyNumbers = Numbers.from(new String[] {});
		assertThat(emptyNumbers.sum()).isEqualTo(Number.from(0));
	}
}