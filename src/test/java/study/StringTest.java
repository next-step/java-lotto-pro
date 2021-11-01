package study;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("문자열")
class StringTest {

	private static Stream<Arguments> split() {
		return Stream.of(
			Arguments.of("1,2", new String[] {"1", "2"}),
			Arguments.of("1", new String[] {"1"})
		);
	}

	@MethodSource
	@ParameterizedTest
	@DisplayName("분리")
	void split(String target, String[] result) {
		assertThat(target.split(","))
			.containsExactly(result);
	}

	@Test
	@DisplayName("자르기")
	void substring() {
		assertThat("(1,2)".substring(1, 4))
			.isEqualTo("1,2");
	}

	@Test
	@DisplayName("문자 길이를 벗어난 문자 위치 검색")
	void charAt_thrownIndexOutOfBoundsException() {
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> "abc".charAt(Integer.MAX_VALUE))
			.withMessageStartingWith("String index out of range");
	}

}
