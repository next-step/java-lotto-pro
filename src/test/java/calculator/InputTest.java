package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class InputTest {

	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("입력이 null 또는 빈문자인 경우 True를 반환한다.")
	void testIsNullOrEmpty(String text) {
		Input input = new Input(text);
		assertThat(input.isNullOrEmpty()).isTrue();
	}

	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "13"})
	@DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
	public void testSplitOneNumber(String text) {
		Input input = new Input(text);

		assertThat(input.values().length).isEqualTo(1);
		assertThat(input.values()).containsExactly(Integer.parseInt(text));
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
	@DisplayName("입력 값을 컴마(,)나 콜론(:)으로 분할해서 int 배열로 가져올 수 있다.")
	void testSplitUsingDefaultDelimiter(String text) {
		Input input = new Input(text);

		assertThat(input.values().length).isEqualTo(3);
		assertThat(input.values()).containsExactly(1, 2, 3);
	}

	@ParameterizedTest
	@ValueSource(strings = {"//;\n1;2;3", "//#\n1#2#3", "//@\n1@2@3"})
	@DisplayName("입력값을 지정된 커스텀 구분자로 분할해서 int 배열로 가져올 수 있다.")
	public void testSplitUsingCustomDelimiter(String text) {
		Input input = new Input(text);

		assertThat(input.values().length).isEqualTo(3);
		assertThat(input.values()).containsExactly(1, 2, 3);
	}
}