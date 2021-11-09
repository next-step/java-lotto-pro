package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BonusBallTest {

	@ParameterizedTest
	@CsvSource(value = {"abc:false", "1:true", "45:true", "0:false", "46:false"}, delimiter = ':')
	void 유효성_검사(String input, boolean expected) {
		boolean result = BonusBall.validate(input);

		assertThat(result).isEqualTo(expected);
	}

}