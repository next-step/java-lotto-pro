package lotto.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringToIntegerParserTest {

	@DisplayName("문자열에 숫자가 있으면 Integer 타입으로 파싱한다.")
	@ParameterizedTest
	@CsvSource(value = {"1:1", "1,2:2", "1,2,3:3", "10,20,30,40:4", "1, 2, 3:3", "1 , 2 , 3:3"}, delimiter = ':')
	void parse(String text, int size) {
		// given
		String[] strings = LottoStringSplitter.split(text);

		// when
		List<Integer> numbers = LottoStringToIntegerParser.parseNumbers(strings);

		// then
		assertThat(numbers).hasSize(size);
	}

	@DisplayName("문자열에 숫자가 아닌 값이 있으면 예외가 발생한다.")
	@ParameterizedTest
	@CsvSource(value = {"a,2,3:a", "1,a,3:a", "1,2,a:a", "a, 2, 3:a", "a , 2 , 3:a"}, delimiter = ':')
	void parse2(String text, String invalidValue) {
		// given
		String[] strings = LottoStringSplitter.split(text);

		// when & then
		assertThatExceptionOfType(NumberFormatException.class)
			.isThrownBy(() -> LottoStringToIntegerParser.parseNumbers(strings))
			.withMessage(MessageBuilder.build("For input string: " + "\"" + invalidValue + "\""));
	}
}