package learningtest;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class BigDecimalTest {

	@Test
	void testBigDecimalToInt() {
		assertThat(BigDecimal.valueOf(3.2).intValue()).isEqualTo(3);
	}
}
