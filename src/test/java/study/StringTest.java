package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	@DisplayName("콤마로 split 했을 때, 분리돼야 한다")
	public void splitTest() {
		String input = "1,2";
		String separator = ",";
		String[] expected = {"1", "2"};

		String[] result = input.split(separator);

		assertThat(result).contains(expected[0]);
		assertThat(result).contains(expected[0], expected[1]);
		assertThat(result).contains(expected);
		assertThat(result).containsExactly(expected);
	}

	@Test
	@DisplayName("()를 제거하고 남은 문자열을 반환해야 한다")
	public void substringTest() {
		String input = "(1,2)";
		String expected = "1,2";
		int beginIdx = 1;
		int endIdx = 4;

		String result = input.substring(beginIdx, endIdx);

		assertThat(result)
			.isNotBlank()
			.isEqualTo(expected);
	}

	@Test
	@DisplayName("특정 위치의 문자를 반환해야 한다")
	public void charAtTest() {
		String input = "abc";
		int idx = 1;
		char expected = 'b';

		char result = input.charAt(idx);

		assertThat(result).isEqualTo(expected);
	}

	@Test
	@DisplayName("인덱스 범위를 벗어난 문자를 가져올 때, StringIndexOutOfBoundsException 이 발생해야 한다")
	public void charAtExceptionTest() {
		String input = "abc";
		int idx = input.length();

		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> input.charAt(idx));
	}
}
