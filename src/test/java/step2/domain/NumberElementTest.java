package step2.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberElementTest {
	@Test
	@DisplayName("음수일 때 RuntimeException 발생")
	void checkNegativeNumber() {
		int negativeNumber = -1;
		assertThatThrownBy(() -> new NumberElement(negativeNumber))
			.isInstanceOf(RuntimeException.class);
	}

	@ParameterizedTest
	@DisplayName("integer 가 아닌 text 일 때 RuntimeException 발생")
	@ValueSource(strings = {"a", "1.1"})
	void checkNotAInteger(String input) {
		assertThatThrownBy(() -> NumberElement.of(input))
			.isInstanceOf(RuntimeException.class);
	}
}
