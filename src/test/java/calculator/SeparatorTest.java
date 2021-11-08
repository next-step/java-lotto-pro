package calculator;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class SeparatorTest {
	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("null 이나 빈 문자열을 전달할 경우 IllegalArgumentException 예외가 발생한다.")
	void testSplitNotAllowedNullOrEmpty(String input) {
		ThrowableAssert.ThrowingCallable throwingCallable = () -> Separator.split(input);

		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(throwingCallable)
			.withMessage(ValueNotSplittableException.VALUE_NOT_SPLITTABLE_ERROR);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "13"})
	@DisplayName("숫자 하나를 문자열로 입력할 경우 동일한 값을 반환한다.")
	public void testSplitOneNumber(String input) {
		String[] results = Separator.split(input);

		assertThat(results.length).isEqualTo(1);
		assertThat(results).containsExactly(input);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
	@DisplayName("입력 값을 컴마(,)나 콜론(:)으로 분할해서 배열로 가져올 수 있다.")
	void testSplitUsingDefaultDelimiter(String text) {
		String[] results = Separator.split(text);

		assertThat(results.length).isEqualTo(3);
		assertThat(results).containsExactly("1", "2", "3");
	}

	@ParameterizedTest
	@ValueSource(strings = {"//;\n1;2;3", "//#\n1#2#3", "//@\n1@2@3"})
	@DisplayName("입력값을 지정된 커스텀 구분자로 분할해서 배열로 가져올 수 있다.")
	public void testSplitUsingCustomDelimiter(String text) {
		String[] results = Separator.split(text);

		assertThat(results.length).isEqualTo(3);
		assertThat(results).containsExactly("1", "2", "3");
	}
}