import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@DisplayName("문자열 분리 테스트")
	@Test
	public void splitTest() {
		// given
		String input = "1,2";
		String delimiter = ",";

		// when
		String[] result = input.split(delimiter);

		// then
		assertThat(result)
			.hasSize(2)
			.containsExactly("1", "2");
	}

	@DisplayName("구분자를 포함하지 않는 문자열 분리 테스트")
	@Test
	public void splitNotContainDelimilterTest() {
		// given
		String input = "1";
		String delimiter = ",";

		// when
		String[] result = input.split(delimiter);

		// then
		assertThat(result)
			.hasSize(1)
			.containsExactly("1");
	}

	@DisplayName("문자열의 특정 시작위치부터 특정 종료위치까지 반환")
	@Test
	public void substringTest() {
		// given
		String input = "(1,2)";
		int begin = 1;
		int end = 4;

		// when
		String result = input.substring(begin, end);

		// then
		assertThat(result)
			.hasSize(end - begin)
			.isEqualTo("1,2");
	}

	@DisplayName("문자열의 특정 위치에 해당하는 문자 반환")
	@Test
	public void charAtTest() {
		// given
		String input = "abc";

		// when
		char[] charAtList = new char[input.length()];
		for (int i = 0; i < input.length(); i++) {
			charAtList[i] = input.charAt(i);
		}

		// then
		assertThat(charAtList).containsExactly(input.toCharArray());
	}

	@DisplayName("문자열 범위에 벗어나는 위치의 문자를 반환할 경우 오류 발생")
	@Test
	public void charAtThrowExceptionWhenOutOfIndexTest() {
		// given
		String input = "abc";
		int outOfIndex = input.length();

		// when/then
		assertThatThrownBy(() -> input.charAt(outOfIndex))
			.isInstanceOf(StringIndexOutOfBoundsException.class);
	}
}
