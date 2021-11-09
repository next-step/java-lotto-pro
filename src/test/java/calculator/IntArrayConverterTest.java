package calculator;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class IntArrayConverterTest {
	@Test
	@DisplayName("String 배열을 int 배열로 변환한다.")
	void testToInts() {
		String[] values = {"1", "2", "3"};

		assertThat(IntArrayConverter.toInts(values).length).isEqualTo(values.length);
		assertThat(IntArrayConverter.toInts(values)).containsExactly(1, 2, 3);
	}

	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("null 이나 빈 배열을 전달할 경우 IllegalArgumentException 예외가 발생한다.")
	void testToIntsNotAllowedNullOrEmpty(String[] values) {
		ThrowableAssert.ThrowingCallable throwingCallable = () -> IntArrayConverter.toInts(values);

		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(throwingCallable)
			.withMessage(ValuesNotConvertibleException.VALUES_NOT_CONVERTABLE_ERROR);
	}

	@Test
	@DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생한다.")
	public void testToIntsNotAllowedNegative() {
		String[] values = {"-1", "2", "3"};

		ThrowableAssert.ThrowingCallable throwingCallable = () -> IntArrayConverter.toInts(values);

		Assertions.assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(throwingCallable)
			.withMessageMatching(NumberOutOfRangeException.OUT_OF_MINIMUM_NUMBER_RANGE_ERROR);
	}
}