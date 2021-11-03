package calculator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열을 자르는 기능을 담당하는 Split 테스트")
class SplitTest {
	private static final String WRONG_INPUT_ERROR_MESSAGE = "숫자가 아닌 입력 값이 존재합니다.";
	private static final String NEGATIVE_NUMBER_INPUT_ERROR_MESSAGE = "입력 값 중 음수가 존재합니다.";

	@DisplayName("빈 값이 들어갔을 때 0을 가지는 배열을 반환하는지 확인하는 테스트")
	@Test
	void validNullInputTest() {
		// given
		String input = "";

		// when
		Split split = new Split(input);

		// then
		assertAll(
			() -> assertThat(split.getStringArray()[0]).isEqualTo("0"),
			() -> assertThat(split.getIntArray()[0]).isEqualTo(0)
		);
	}

	@DisplayName("기본 구분자 ','와':' 를 사용했을 때 잘 분리되는지 확인하는 테스트")
	@Test
	void normalTokenTest() {
		// given
		String input = "1,2:3";

		// when
		Split split = new Split(input);

		// then
		assertAll(
			() -> assertThat(split.getStringArray()).isInstanceOf(String[].class),
			() -> assertThat(split.getStringArray()).hasSize(3),
			() -> assertThat(split.getStringArray()[0]).isEqualTo("1"),
			() -> assertThat(split.getStringArray()[1]).isEqualTo("2"),
			() -> assertThat(split.getStringArray()[2]).isEqualTo("3")
		);
	}

	@DisplayName("커스텀 구분자를 사용했을 때 잘 분리되는지 확인하는 테스트")
	@Test
	void customTokenTest() {
		// given
		String input = "//a\n1a2a3";

		// when
		Split split = new Split(input);

		// then
		assertThat(split.getStringArray()).hasSize(3);
	}

	@DisplayName("String 배열을 int 배열로 바꾸는 메소드 테스트")
	@Test
	void convertStringArrayToIntArray() {
		// given
		String input = "//d\n1d2d3";
		Split split = new Split(input);

		// when
		split.convertStringArrayToIntArray();
		int[] intArray = split.getIntArray();

		// then
		assertThat(intArray).contains(1, 2, 3);
	}

	@DisplayName("String 배열을 int 배열로 변환 중, 숫자 형태의 값이 아닌 다른 값이 존재할 때 RunException 발생 테스트")
	@Test
	void exceptionIsNotNumber() {
		// given
		String input = "1:r,5";

		// when // then
		assertThatThrownBy(
			() -> {
				Split split = new Split(input);
			}
		).isInstanceOf(RuntimeException.class)
			.hasMessageContaining(WRONG_INPUT_ERROR_MESSAGE);
	}

	@DisplayName("String 배열을 int 배열로 변환 중, 음수 값 존재할 때 RunException 발생 테스트")
	@Test
	void exceptionNegativeNumber() {
		// given
		String input = "1:-1:3";

		// when // then
		assertThatThrownBy(
			() -> {
				Split split = new Split(input);
			}
		).isInstanceOf(RuntimeException.class)
			.hasMessageContaining(NEGATIVE_NUMBER_INPUT_ERROR_MESSAGE);
	}
}