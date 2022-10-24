package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringTest {
	@DisplayName("문자열 1,2을 콤마(,)로 split")
	@Test
	void split() {
		final String[] actual = "1,2".split(",");
		assertThat(actual).containsExactly("1", "2");
	}

	@DisplayName("문자열 1 콤마(,)로 split")
	@Test
	void splitSingle() {
		final String[] actual = "1".split(",");
		assertThat(actual).containsExactly("1");
	}

	@DisplayName("문자열 (1,2) substring 메소드로 괄호 제거")
	@Test
	void substring() {
		final String actual = "(1,2)".substring(1, 4);
		assertThat(actual).isEqualTo("1,2");
	}

	@DisplayName("문자열 abc chatAt 메소드로 특정 문자 가져오기")
	@ParameterizedTest
	@CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
	void charAt(int index, char expected) {
		final char actual = "abc".charAt(index);
		assertThat(actual).isEqualTo(expected);
	}

	@DisplayName("charAt 메소드 인덱스 범위 바깥 StringIndexOutOfBoundsException 발생")
	@ParameterizedTest
	@ValueSource(ints = {-1, 3})
	void charAt_StringIndexOutOfBoundsException(int index) {
		assertThatThrownBy(() -> "abc".charAt(index))
			.isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining(String.format("String index out of range: %d", index));
	}
}
