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
}
