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

	@ParameterizedTest
	@CsvSource(value = {
		"FIRST : 2 : 4000000000",
		"SECOND : 1 : 1500000",
		"THIRD : 5 : 250000",
		"FORTH : 4 : 20000",
		"NOTHING : 10 : 0",
	}, delimiter = ':')
	void 랭크갯수에따라_당첨금액을_반환하는_기능테스트(String rank, int count, int sumMoney) {
		// given // when
		int sum = RankCode.getRankMoney(RankCode.valueOf(rank), count);

		// then
		assertThat(sum).isEqualTo(sumMoney);
	}
}