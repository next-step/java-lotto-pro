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
}