package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PositiveNumberTest {

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 10, 1234})
	@DisplayName("숫자를 통해 생성할 수 있다")
	public void ofTest(int inputNumber) {
		// when
		PositiveNumber number = PositiveNumber.of(inputNumber);

		// then
		assertThat(number).isEqualTo(PositiveNumber.of(inputNumber));
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, -1000})
	public void ofValidateTest(int inputNumber) {
		// when, then
		assertThatThrownBy(() -> PositiveNumber.of(inputNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 4, 5, 0, 100})
	@DisplayName("가지고 있는 숫자를 int로 반환한다")
	public void toIntTest(int number) {
		// given
		PositiveNumber positiveNumber = PositiveNumber.of(number);

		// when
		int result = positiveNumber.toInt();

		// then
		assertThat(result).isEqualTo(number);
	}

	@Test
	@DisplayName("주어진 숫자보다 작은지 확인할 수 있어야 한다")
	public void isLessThenTest() {
		// given
		PositiveNumber number = PositiveNumber.of(3);
		PositiveNumber greaterNumber1 = PositiveNumber.of(4);
		PositiveNumber greaterNumber2 = PositiveNumber.of(100);
		PositiveNumber lessNumber1 = PositiveNumber.of(2);
		PositiveNumber lessNumber2 = PositiveNumber.of(0);

		// when, then
		assertThat(number.isLessThan(greaterNumber1)).isEqualTo(true);
		assertThat(number.isLessThan(greaterNumber2)).isEqualTo(true);
		assertThat(number.isLessThan(lessNumber1)).isEqualTo(false);
		assertThat(number.isLessThan(lessNumber2)).isEqualTo(false);
	}

	@Test
	@DisplayName("주어진 숫자보다 큰지 확인할 수 있어야 한다")
	public void isGreaterThenTest() {
		// given
		PositiveNumber number = PositiveNumber.of(3);
		PositiveNumber greaterNumber1 = PositiveNumber.of(4);
		PositiveNumber greaterNumber2 = PositiveNumber.of(100);
		PositiveNumber lessNumber1 = PositiveNumber.of(2);
		PositiveNumber lessNumber2 = PositiveNumber.of(0);

		// when, then
		assertThat(number.isGreaterThan(greaterNumber1)).isEqualTo(false);
		assertThat(number.isGreaterThan(greaterNumber2)).isEqualTo(false);
		assertThat(number.isGreaterThan(lessNumber1)).isEqualTo(true);
		assertThat(number.isGreaterThan(lessNumber2)).isEqualTo(true);
	}
}
