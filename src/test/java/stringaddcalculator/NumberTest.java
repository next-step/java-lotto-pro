package stringaddcalculator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {

	@DisplayName("더하기")
	@Test
	void sum() {
		assertThat(new Number(3).sum(new Number(5))).isEqualTo(new Number(8));
	}

	@DisplayName("음수 여부 확인")
	@Test
	void isNegative() {
		assertThat(new Number(3).isNegative()).isFalse();
		assertThat(new Number(-1).isNegative()).isTrue();
	}
}