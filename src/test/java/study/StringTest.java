package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringTest {

	@Test
	@DisplayName("콤마로 split 했을 때, 분리돼야 한다")
	public void splitTest() {
		// given
		String input = "1,2";
		String separator = ",";
		String[] expected = {"1", "2"};

		// when
		String[] result = input.split(separator);

		// then
		assertThat(result).contains(expected);
		assertThat(result).containsExactly(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2:1:4", "2:3:4", ",:2:3"}, delimiter = ':')
	@DisplayName("주어진 범위의 부분 문자열을 반환해야 한다")
	public void substringTest(String expected, int beginIdx, int endIdx) {
		// given
		String input = "(1,2)";

		// when
		String result = input.substring(beginIdx, endIdx);

		// then
		assertThat(result)
			.isNotBlank()
			.isEqualTo(expected);
	}

	@Test
	@DisplayName("인덱스 범위를 벗어난 부분 문자열을 구할 때, StringIndexOutOfBoundsException 가 발생해야 한다")
	public void substringExceptionTest() {
		// given
		String input = "(1,2)";
		int beginIdx = 1;
		int endIdx = input.length() + 1;

		// when, then
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> input.substring(beginIdx, endIdx));
	}

	@ParameterizedTest
	@CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
	@DisplayName("특정 위치의 문자를 반환해야 한다")
	public void charAtTest(int idx, char expected) {
		// given
		String input = "abc";

		// when
		char result = input.charAt(idx);

		// then
		assertThat(result).isEqualTo(expected);
	}

	@Test
	@DisplayName("인덱스 범위를 벗어난 문자를 가져올 때, StringIndexOutOfBoundsException 이 발생해야 한다")
	public void charAtExceptionTest() {
		// given
		String input = "abc";
		int idx = input.length();

		// when, then
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> input.charAt(idx));
	}
}
