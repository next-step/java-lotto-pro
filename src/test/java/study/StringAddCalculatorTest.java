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

	@Test
	public void splitAndSum_쉼표구분자() throws Exception {
		String text = "1,2";
		int result = StringAddCalculator.splitAndSum(text);
		assertThat(result).isEqualTo(3);
	}

	@Test
	public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
		String text = "1,2:3";
		int result = StringAddCalculator.splitAndSum(text);
		assertThat(result).isEqualTo(6);
	}
}
