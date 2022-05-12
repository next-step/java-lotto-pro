package model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberTest {
	@Test
	@DisplayName("숫자가 아닌 값이나 음수가 입력된 경우 예외발생 테스트")
	void number_test_예외테스트() {
		assertAll(() -> assertThrows(RuntimeException.class, () -> new Number("a")),
				() -> assertThrows(RuntimeException.class, () -> new Number("-1")));
	}

	@Test
	@DisplayName("생성 테스트")
	void number_test() {
		assertEquals(new Number("3").getNumber(), 3);
	}
}
