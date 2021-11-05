import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoParserTest {

	@Test
	void parse() {
		final List<LottoNumber> lotto = LottoParser.parse("1, 2, 3, 6, 5, 4");
		assertThat(lotto).containsExactlyElementsOf(
			Stream.iterate(LottoNumber.MIN_INCLUSIVE_NUMBER, num -> num + 1)
				.limit(Lotto.NUM_OF_LOTTO_NUMBERS)
				.map(LottoNumber::from)
				.collect(Collectors.toList())
		);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,2", "1,2,3,4,5,6,7"})
	void parse_invalidLength(String s) {
		assertThatExceptionOfType(LottoFormatException.class)
			.isThrownBy(() -> LottoParser.parse(s))
			.withMessage(LottoFormatException.ERROR_MESSAGE);
	}

	@Test
	void parse_notNumber() {
		assertThatExceptionOfType(LottoNumberFormatException.class)
			.isThrownBy(() -> LottoParser.parse("a,b,c,1,2,3"))
			.withMessage(LottoNumberFormatException.ERROR_MESSAGE);
	}
}
