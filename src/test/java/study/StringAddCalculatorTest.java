package study;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {
	@Test
	public void splitAndSum_null_또는_빈문자() {
		String text = null;
		int result = StringAddCalculator.splitAndSum(text);
		assertThat(result).isEqualTo(0);

		text = "";
		result = StringAddCalculator.splitAndSum(text);
		assertThat(result).isEqualTo(0);
	}

	@Test
	public void splitAndSum_숫자하나() throws Exception {
		String text = "1";
		int result = StringAddCalculator.splitAndSum(text);
		assertThat(result).isEqualTo(1);
	}
}
