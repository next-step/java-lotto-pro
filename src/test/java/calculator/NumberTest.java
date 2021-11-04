package calculator;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class NumberTest {
	@Test
	public void 음수_확인() {
		assertThatThrownBy(() -> new Number("-1"))
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("음수는 입력 할 수 없습니다.");
	}

	@Test
	public void 문자_확인() {
		assertThatThrownBy(() -> new Number("@"))
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("문자는 입력 할 수 없습니다.");
	}
}
