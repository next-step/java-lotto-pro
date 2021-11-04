package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilTest {

	@Test
	@DisplayName("'1,2' 문자열을 ',' 로 split 테스트")
	void splitTest1() {
		// given
		String testString = "1,2";

		// when
		String[] result = testString.split(",");

		// then
		assertThat(result).contains("1", "2");
		assertThat(result).containsExactly("1", "2");
	}

	@Test
	@DisplayName("'1' 문자열을 ',' 로 split 테스트")
	void splitTest2() {
		// given
		String testString = "1";

		// when
		String[] result = testString.split(",");

		// then
		assertThat(result).contains("1");
		assertThat(result).containsExactly("1");
	}

	@Test
	@DisplayName("'(1,2)' -> '1,2' substring 테스트")
	void substringTest() {
		// given
		String testString = "(1,2)";

		// when
		String result = testString.substring(1, 4);

		// then
		assertThat(result).isEqualTo("1,2");
	}

	@Test
	@DisplayName("'abc' 에서 특정 위치의 문자 가져오기 - 정상")
	void charAtTest1() {
		// given
		String testString = "abc";

		// when
		char resultA = testString.charAt(0);
		char resultB = testString.charAt(1);
		char resultC = testString.charAt(2);

		// then
		assertThat(resultA).isEqualTo('a');
		assertThat(resultB).isEqualTo('b');
		assertThat(resultC).isEqualTo('c');
	}

	@Test
	@DisplayName("'abc' 에서 특정 위치의 문자 가져오기 - StringIndexOutOfBoundsException 발생")
	void charAtTest2() {
		// given
		String testString = "abc";

		// then
		assertThatThrownBy( () -> {
			// when
			testString.charAt(3);
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
		.hasMessageContaining("String index out of range");
	}
}
