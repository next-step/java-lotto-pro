import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorNumberTest {

	@Test
	@DisplayName("음수일 경우 생성시 예외 발생")
	public void test_constructor1() {
		assertThatThrownBy(() -> {
			new CalculatorNumber(-1);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessage(CalculatorNumber.MESSAGE_ILLEGAL_NEGATIVE_NUMBER);
	}
}
