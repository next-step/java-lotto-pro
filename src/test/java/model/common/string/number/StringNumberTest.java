package model.common.string.number;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("문자열 숫자")
class StringNumberTest {

	@ParameterizedTest(name = "{displayName}[{index}] {0} can be instanced")
	@DisplayName("객체화")
	@NullAndEmptySource
	@ValueSource(strings = {"1", "123"})
	void instance(String given) {
		//when, then
		assertThatNoException()
			.isThrownBy(() -> StringNumber.of(given));
	}

	@ParameterizedTest(name = "{displayName}[{index}] {0} parsed result is {1}")
	@CsvSource(value = {",0", "'',0", "1,1"})
	void parseInt(String target, int expected) {
		//when
		int parseInt = StringNumber.of(target)
			.parseInt();

		//then
		assertThat(parseInt)
			.isEqualTo(expected);
	}

	@Test
	@DisplayName("음수를 변형하면 RuntimeException 발생")
	void parseInt_negative_thrownRuntimeException() {
		//given, when
		ThrowingCallable throwingCallable = () -> StringNumber.of("-1").parseInt();

		//then
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(throwingCallable)
			.withMessageContaining("must not be negative");
	}
}
