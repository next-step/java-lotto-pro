package stringaddcalculator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {

	@DisplayName("음수 포함 여부 확인")
	@Test
	void containsNegative() {
		Numbers nonNegativeNumbers = new Numbers(new String[]{"1","2","3"});
		assertThat(nonNegativeNumbers.containsNegative()).isFalse();
		Numbers hasNegativeNumbers = new Numbers(new String[]{"1","-2","3"});
		assertThat(hasNegativeNumbers.containsNegative()).isTrue();
	}

	@Test
	void sum() {
		Numbers numbers = new Numbers(new String[]{"1","2","3"});
		assertThat(numbers.sum()).isEqualTo(new Number(6));
	}
}