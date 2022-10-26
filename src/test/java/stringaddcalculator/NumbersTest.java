package stringaddcalculator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {
	@DisplayName("음수 포함 여부")
	@Test
	void containsNegative() {
		Numbers nonNegativeNumbers = Numbers.from(new String[]{"1","2","3"});
		assertThat(nonNegativeNumbers.containsNegative()).isFalse();
		Numbers hasNegativeNumbers = Numbers.from(new String[]{"1","-2","3"});
		assertThat(hasNegativeNumbers.containsNegative()).isTrue();
	}

	@DisplayName("합계")
	@Test
	void sum() {
		Numbers numbers = Numbers.from(new String[]{"1","2","3"});
		assertThat(numbers.sum()).isEqualTo(Number.from(6));
	}
}