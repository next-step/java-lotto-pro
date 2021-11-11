package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {

	@ParameterizedTest
	@CsvSource(value = {
		"6 : 0 : FIRST",
		"5 : 1 : SECOND",
		"5 : 0 : THIRD",
		"4 : 0 : FORTH",
		"3 : 0 : FIFTH",
		"2 : 0 : NOTHING",
		"1 : 0 : NOTHING",
		"0 : 0 : NOTHING"
	}, delimiter = ':')
	void 일치갯수에따라_RankCode를_반환하는_기능테스트(int containCount, int bonusCount, String rankCodeName) {
		// given // when // then
		assertThat(LottoRank.getRankCode(containCount, bonusCount)).isEqualTo(LottoRank.valueOf(rankCodeName));
	}

	@ParameterizedTest
	@CsvSource(value = {
		"FIRST : 1 : 2000000000",
		"SECOND : 1 : 30000000",
		"THIRD : 1 : 1500000",
		"FORTH : 5 : 250000",
		"FIFTH : 4 : 20000",
		"NOTHING : 10 : 0",
	}, delimiter = ':')
	void 랭크갯수에따라_당첨금액을_반환하는_기능테스트(String rank, int count, int sumMoney) {
		// given // when
		Money sum = LottoRank.getRankMoney(LottoRank.valueOf(rank), count);

		// then
		assertThat(sum.getMoney()).isEqualTo(sumMoney);
	}
}