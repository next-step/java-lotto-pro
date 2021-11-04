import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorNumbersTest {

	@Test
	@DisplayName("음수가 포함되어 있을 경우 생성시 예외 발생")
	public void test_constructor1() {
		assertThatThrownBy(() -> {
			new CalculatorNumbers(Arrays.asList(-1, 0, 1));
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessage(CalculatorNumber.MESSAGE_ILLEGAL_NEGATIVE_NUMBER);
	}
}
