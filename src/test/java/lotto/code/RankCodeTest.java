package lotto.code;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankCodeTest {

	@ParameterizedTest
	@CsvSource(value = {
		"6 : FIRST",
		"5 : SECOND",
		"4 : THIRD",
		"3 : FORTH",
		"2 : NOTHING",
		"1 : NOTHING",
		"0 : NOTHING"
	}, delimiter = ':')
	void 일치갯수에따라_RankCode를_반환하는_기능테스트(int containCount, String rankCodeName) {
		// given // when // then
		assertThat(RankCode.getRankCode(containCount)).isEqualTo(RankCode.valueOf(rankCodeName));
	}
}