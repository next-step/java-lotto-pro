package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {

	@Test
	void 빈문자열이나_null_입력시_0_반환() {
		Assertions.assertThat(StringAddCalculator.calculate("")).isEqualTo(0);
		Assertions.assertThat(StringAddCalculator.calculate(null)).isEqualTo(0);
	}

	@ParameterizedTest
	@CsvSource(value = {"1:1", "2:2", "3:3", "10:10"}, delimiter = ':')
	void 단일_숫자형_문자_입력시_숫자_반환(String actual, int expected) {
		Assertions.assertThat(StringAddCalculator.calculate(actual)).isEqualTo(expected);
	}

	@Test
	void 쉼표로_구분된_값을_합산() {
		Assertions.assertThat(StringAddCalculator.calculate("1,2")).isEqualTo(3);
	}

	@Test
	void 쉼표와_콜론으로_구분된_값을_합산() {
		Assertions.assertThat(StringAddCalculator.calculate("1,2:3")).isEqualTo(6);
	}

	@Test
	void 구분자_지정_사용_합산() {
		Assertions.assertThat(StringAddCalculator.calculate("//;\n1;2;3")).isEqualTo(6);
	}

	@Test
	void 음수_입력시_에러() {
		Assertions.assertThatThrownBy(() -> StringAddCalculator.calculate("-1,2:3"))
			.isInstanceOf(RuntimeException.class)
			.hasMessage("음수는 사용이 불가능");
	}
}