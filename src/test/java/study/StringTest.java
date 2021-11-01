package study;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("문자열")
class StringTest {

	@Test
	@DisplayName("구분자가 포함된 문자열 분리")
	void split() {
		//given, when
		String[] splitStrings = "1,2".split(",");

		//then
		assertThat(splitStrings)
			.containsExactly("1", "2");
	}

	@Test
	@DisplayName("구분자 없는 문자열 분리")
	void split_withoutDelimiter() {
		//given, when
		String[] splitStrings = "1".split(",");

		//then
		assertThat(splitStrings)
			.containsExactly("1");
	}

	@Test
	@DisplayName("양 끝 문자 자르기")
	void substring() {
		//given
		String stringWithParentheses = "(1,2)";

		//when
		String substring = stringWithParentheses.substring(1, stringWithParentheses.length() - 1);

		//then
		assertThat(substring)
			.isEqualTo("1,2");
	}

	@ParameterizedTest(name = "{displayName}[{index}] index {0} of abc is {1}")
	@DisplayName("abc 특정 위치의 문자 가져오기")
	@CsvSource({"0,a", "1,b", "2,c"})
	void charAt(int index, char expected) {
		//when
		char characterByIndex = "abc".charAt(index);

		//then
		assertThat(characterByIndex)
			.isEqualTo(expected);
	}

	@Test
	@DisplayName("문자 길이를 벗어난 위치로 검색하면 StringIndexOutOfBoundsException 발생")
	void charAt_outIndex_thrownIndexOutOfBoundsException() {
		//given, when
		ThrowingCallable callCharAt = () -> "abc".charAt(Integer.MAX_VALUE);

		//then
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(callCharAt)
			.withMessageStartingWith("String index out of range");
	}

}
