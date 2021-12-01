package utils;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class IntegerParserTest {
	@DisplayName("문자열을 특정 구분자로 파싱하여 숫자 배열로 반환")
	@Test
	public void toStringParserTest() {
		// given
		String delimiter = ",";
		String input = "1, 2, 3, 4, 5, 6";
		List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);

		// when
		assertThat(IntegerParser.toInteger(input, delimiter))
			.containsAll(expected);
	}

	@DisplayName("유효하지 않은 값 입력 시 예외")
	@ParameterizedTest
	@CsvSource(value = {
		"1,2,3,",
		"a,b,c",
		"1,b,3",
	})
	public void throwExceptionWhenInvalidInputTest() {
		// given
		String delimiter = ",";
		String input = "1, sd, 1, f";

		// when
		assertThatThrownBy(() -> IntegerParser.toInteger(input, delimiter))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
