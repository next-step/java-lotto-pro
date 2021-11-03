import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class LottoParserTest {

	@Test
	void parse() {
		final List<LottoNumber> lotto = LottoParser.parse("1, 2, 3, 4, 5, 6");
		assertThat(lotto.size()).isEqualTo(Lotto.NUM_OF_LOTTO_NUMBERS);
	}

	@Test
	void parse_tooShort() {
		assertThatExceptionOfType(LottoFormatException.class)
			.isThrownBy(() -> LottoParser.parse("1, 2"))
			.withMessage(LottoFormatException.ERROR_MESSAGE);
	}

	@Test
	void parse_notNumber() {
		assertThatExceptionOfType(LottoNumberFormatException.class)
			.isThrownBy(() -> LottoParser.parse("a,b,c,1,2,3"))
			.withMessage(LottoNumberFormatException.ERROR_MESSAGE);
	}
}
