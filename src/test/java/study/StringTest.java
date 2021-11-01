package study;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@DisplayName("split 배열 값 확인")
	@Test
	void splitUnitContains() {
		String[] result = "1,2".split(",");
		assertThat(result).contains("1", "2");
	}

	@DisplayName("split 배열 값 완전 일치하는지 확인")
	@Test
	void splitUnitContainsExactly() {
		String[] result = "1,".split(",");
		assertThat(result).containsExactly("1");
	}

	@DisplayName("문자열 substring 동작 확인")
	@Test
	void substring() {
		String data = "(1,2)";
		String result = data.substring(data.indexOf("(") + 1, data.indexOf(")"));
		assertThat(result).isEqualTo("1,2");
	}

	@DisplayName("String의 charAt() 메소드 확인")
	@Test
	void charAt() {
		assertThat("abc".charAt(0)).isEqualTo('a');
		assertThat("abc".charAt(1)).isEqualTo('b');
		assertThat("abc".charAt(2)).isEqualTo('c');
	}

	@DisplayName("String의 charAt() 메소드 IndexOutOfBoundsException 확인")
	@Test
	void stringIndexOutOfBoundsException() {
		final String strTest = "abc";
		final int position = 4;
		assertThatExceptionOfType(IndexOutOfBoundsException.class)
			.isThrownBy(() -> {
				strTest.charAt(position);
			}).withMessageMatching("String index out of range: \\d+");
	}
}
