package studytest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringStudyTest {

	@Test
	@DisplayName("1,2 를 , 로 split 할 경우 1, 2 를 포함한 배열 반환")
	void splitTest() {
		String[] split = "1,2".split(",");
		assertThat(split).containsExactly("1", "2");
	}

	@Test
	@DisplayName("1 을 , 로 split 할 경우 1 을 포함한 배열 반환")
	void splitSingleValueTest() {
		String[] split = "1".split(",");
		assertThat(split).containsExactly("1");
	}

	@Test
	@DisplayName("(1,2) 를 substring 할 경우 1,2 반환")
	void subStringTest() {
		String input = "(1,2)";
		String substring = input.substring(1, input.length() - 1);
		assertThat(substring).isEqualTo("1,2");
	}

	@ParameterizedTest(name = "{index} => input={0}, expected={1}")
	@DisplayName("charAt 으로 특정 위치 문자 반환")
	@CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
	void charAtTest(int index, char expected) {
		String input = "abc";
		assertThat(input.charAt(index)).isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("charAt 이 index 를 벗어 날 경우 StringIndexOutOfBoundsException 발생")
	@ValueSource(ints = {-1, 4, 5})
	void charAtExceptionTest(int index) {
		String input = "abc";
		assertThatThrownBy(() -> input.charAt(index))
			.isInstanceOf(StringIndexOutOfBoundsException.class);
	}
}