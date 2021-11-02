package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	void split() {
		String[] result = "1,2".split(",");
		assertThat(result).containsExactly("1", "2");
	}

	@Test
	void substring() {
		String result = "(1,2)".substring(1, 4);
		assertThat(result).isEqualTo("1,2");
	}

	@Test
	@DisplayName("chatAt 함수의 인자가 인덱스 범위를 벗어나는 경우 StringIndexOutOfBoundsException 발생")
	void chatAt_when_index_out_of_bounds() {
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> "abc".charAt(4));
	}
}
