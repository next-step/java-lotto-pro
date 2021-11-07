package lotto.common;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
	@Test
	void profitRate_수익률_계산() {
		double profitRate = Calculator.profitRate(14000, 5000);
		assertThat(profitRate).isEqualTo(0.35);
	}
}
