package study.step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import step2.StringAddCalculator;

public class StringAddCalculatorTest {
	@Test
	public void splitAndSum_null_또는_빈문자() {
		int result = StringAddCalculator.splitAndSum(null);
		assertThat(result).isEqualTo(0);

		result = StringAddCalculator.splitAndSum("");
		assertThat(result).isEqualTo(0);
	}
}
