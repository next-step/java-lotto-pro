package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParserTest {

	Parser parser;

	@BeforeEach
	public void setup() {
		parser = new Parser();
	}

	@Test
	@DisplayName("콤마 구분자로 입력하면, 파싱하여 숫자들을 반환해야 한다")
	public void commaParseTest() {
		// given
		String input = "1,2";
		Integer[] expected = {1, 2};

		// when
		List<Integer> numbers = parser.parse(input);

		// then
		assertThat(numbers).containsExactly(expected);
	}

	@Test
	@DisplayName("콜론 구분자로 입력하면, 파싱하여 숫자들을 반환해야 한다")
	public void colonParseTest() {
		// given
		String input = "1:2:3";
		Integer[] expected = {1, 2, 3};

		// when
		List<Integer> numbers = parser.parse(input);

		// then
		assertThat(numbers).containsExactly(expected);
	}

	@Test
	@DisplayName("커스텀 구분자로 입력하면, 파싱하여 숫자들을 반환해야 한다")
	public void customParseTest() {
		// given
		String input = "//;\n1;2;3";
		Integer[] expected = {1, 2, 3};

		// when
		List<Integer> numbers = parser.parse(input);

		// then
		assertThat(numbers).containsExactly(expected);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1:a:3", "a:1:2", "a", "//;\n1;2;z", "z"})
	@DisplayName("숫자가 아닌 문자를 입력하면, RuntimeException이 발생해야 한다")
	public void exceptionTest(String input) {
		// when, then
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> parser.parse(input));

	}

	@Test
	@DisplayName("단일 숫자로 된 문자열을 입력하면, 단일 숫자만 반환해야 한다")
	public void singleNumberTest() {
		// given
		String input = "1";
		Integer[] expected = {1};

		// when
		List<Integer> numbers = parser.parse(input);

		// then
		assertThat(numbers).containsExactly(expected);
	}

}
