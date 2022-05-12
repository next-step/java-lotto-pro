package util;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	@DisplayName("Null이나 빈 문자열에 대한 합계를 테스트")
	void sum_test_빈문자와널() {
		assertAll(() -> assertEquals(Calculator.sum(null), 0), 
				() -> assertEquals(Calculator.sum(""), 0));
	}

	@Test
	@DisplayName("기본으로 제공되는 구분자로 구분된 문자열에 대한 합계를 테스트")
	void sum_test_기본구분자() {
		assertAll(() -> assertEquals(Calculator.sum("1,2"), 3), 
				() -> assertEquals(Calculator.sum("1:2"), 3),
				() -> assertEquals(Calculator.sum("1,2,3"), 6), 
				() -> assertEquals(Calculator.sum("1:2,3"), 6));
	}

	@Test
	@DisplayName("사용자가 원하는 구분자로 구분된 문자열에 대한 합계를 테스트")
	void sum_test_커스텀구분자() {
		assertAll(() -> assertEquals(Calculator.sum("//!\n1!2"), 3));
	}

	@Test
	@DisplayName("숫자가 아닌 값이나 음수가 입력된 경우 예외발생 테스트")
	void sum_test_예외테스트() {
		assertAll(() -> assertThrows(RuntimeException.class, () -> Calculator.sum("-1,2,3")),
				() -> assertThrows(RuntimeException.class, () -> Calculator.sum("1,a,3")));
	}
}
