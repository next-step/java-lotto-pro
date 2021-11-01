package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	@DisplayName("문자열이 split에 의해 여러개로 분리가 된다.")
	void splitAll() {
		assertThat("1,2".split(",")).containsExactly("1", "2");
	}

	@Test
	@DisplayName("분리대상이 하나인 문자열도 split으로 분리가 된다.")
	void splitSingle() {
		assertThat("1".split(",")).containsExactly("1");
	}

	@Test
	@DisplayName("substring을 사용하여 문자열의 일부를 추출할 수 있다.")
	void substring() {
		String data = "(1,2)";
		assertThat(data.substring(1, data.length() - 1)).isEqualTo("1,2");
	}

	@Test
	@DisplayName("charAt을 사용하여 특정위치의 문자를 가져오고, 예외발생을 확인한다")
	void charAt() {
		assertThat("abc".charAt(1)).isEqualTo('b');

		assertThatThrownBy(() -> {
			"abc".charAt(3);
		}).isInstanceOf(IndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range: 3");

		assertThatExceptionOfType(IndexOutOfBoundsException.class)
			.isThrownBy(() -> {
				"abc".charAt(3);
			}).withMessageMatching("String index out of range: \\d+");
	}
}
