package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	@DisplayName("문자열이 split에 의해 여러개로 분리가 된다.")
	void splitAll() {
		String[] result = "1,2".split(",");
		assertThat(result).containsExactly("1","2");
	}

	@Test
	@DisplayName("분리대상이 하나인 문자열도 split으로 분리가 된다.")
	void splitSingle() {
		String[] result = "1".split(",");
		assertThat(result).containsExactly("1");
	}

	@Test
	@DisplayName("substring을 사용하여 문자열의 일부를 추출할 수 있다.")
	void substring() {
		String data = "(1,2)";
		String result = data.substring(1, data.length() - 1);
		assertThat(result).isEqualTo("1,2");
	}
}
