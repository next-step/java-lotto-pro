package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	@DisplayName("'1,2'를 ,로 split")
	@Test
	void two_value_split() {
		// given, when, then
		assertThat("1,2".split(",")).containsExactly("1", "2");
	}

	@DisplayName("'1'을 ,로 split")
	@Test
	void one_value_split() {
		// given, when, then
		assertThat("1".split(",")).containsExactly("1");
	}

	@DisplayName("substring 테스트")
	@Test
	void substring_test() {
		// given, when, then
		assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
	}

	@DisplayName("chartAt 테스트")
	@Test
	void charAt_test() {
		// given, when, then
		assertThat("abc".charAt(1)).isEqualTo('b');
	}

	@DisplayName("StringIndexOutOfBoundsException 테스트")
	@Test
	void stringIndexOutOfBoundsException_test() {
		// given, when, then
		assertThatThrownBy(()-> "abc".charAt(5))
			.isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range");
	}
}
